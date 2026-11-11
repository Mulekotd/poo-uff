package proxy;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Proxy {
    private static final int MIN_SERVERS = 1;
    private static final int MAX_SERVERS = 127;
 
    private static final int MIN_CLIENTS = 100;
    private static final int MAX_CLIENTS = 10000;
 
    private static final int WORKER_THREADS = Runtime.getRuntime().availableProcessors() * 2;
 
    private final String ipv4;
    private final List<Server> servers;
    private final List<Client> clients;
    private final ExecutorService workers;
 
    public Proxy() {
        this.ipv4 = NetworkUtils.generateIPv4();
        this.servers = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.workers = Executors.newFixedThreadPool(WORKER_THREADS);
    }
 
    // Getters
 
    public String getIPv4() {
        return this.ipv4;
    }
 
    public List<Server> getServers() {
        return Collections.unmodifiableList(this.servers);
    }
 
    public List<Client> getClients() {
        return Collections.unmodifiableList(this.clients);
    }
 
    // Methods
 
    /** Deve ser chamado antes de começar a receber requisições (a lista não é alterada depois). */
    public void populateServers() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int total = random.nextInt(MIN_SERVERS, MAX_SERVERS + 1);

        for (int i = 0; i < total; i++) {
            this.servers.add(new Server());
        }
    }
 
    public void populateClients() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int total = random.nextInt(MIN_CLIENTS, MAX_CLIENTS + 1);

        for (int i = 0; i < total; i++) {
            this.clients.add(new Client());
        }
    }
 
    /**
     * Ponto de entrada das requisições. Retorna imediatamente; o processamento
     * (busca + download bit a bit) roda em uma thread do pool.
     */
    public CompletableFuture<Response> handle(Request request) {
        return CompletableFuture.supplyAsync(() -> process(request), this.workers);
    }
 
    /** Encerra o pool, aguardando as transferências em andamento. */
    public void shutdown() throws InterruptedException {
        this.workers.shutdown();
        this.workers.awaitTermination(1, TimeUnit.MINUTES);
    }
 
    // Internals
 
    private Response process(Request request) {
        long start = System.nanoTime();
        String name = request.getFileName();
 
        Server holder = null; // servidor que possui o arquivo (preferência por um UP)

        for (Server server : this.servers) {
            if (server.getFiles().containsKey(name)) {
                holder = server;
                if (server.isReachable()) break;
            }
        }
 
        if (holder == null) {
            return new Response(request, Response.Result.FILE_NOT_FOUND, null, null, 0,
                    System.nanoTime() - start);
        }
        if (!holder.isReachable()) {
            return new Response(request, Response.Result.SERVER_UNAVAILABLE, holder.getIPv4(), null, 0,
                    System.nanoTime() - start);
        }
 
        return download(request, holder, holder.getFiles().get(name), start);
    }
 
    /**
     * "Baixa" o arquivo bit a bit (do bit mais significativo ao menos significativo de
     * cada byte), remontando o conteúdo. Se o servidor cair no meio, a transferência aborta.
     */
    private Response download(Request request, Server server, File file, long start) {
        byte[] source = file.getContent();
        byte[] received = new byte[source.length];
        long bits = 0;
 
        for (int i = 0; i < source.length; i++) {
            if (!server.isReachable()) {
                return new Response(request, Response.Result.SERVER_UNAVAILABLE, server.getIPv4(),
                        null, bits, System.nanoTime() - start);
            }

            for (int b = 7; b >= 0; b--) {
                int bit = (source[i] >> b) & 1;   // lê 1 bit do servidor
                received[i] |= (byte) (bit << b); // grava no buffer do cliente
                bits++;
            }
        }
 
        return new Response(request, Response.Result.OK, server.getIPv4(),
                received, bits, System.nanoTime() - start);
    }
}
