import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import proxy.Client;
import proxy.File;
import proxy.Proxy;
import proxy.Request;
import proxy.Response;
import proxy.Server;
import proxy.Status;

public class ProgramaProxy {
    private static final int TOTAL_REQUESTS = 500;
 
    public static void main(String[] args) throws Exception {
        Proxy proxy = new Proxy();
        proxy.populateServers();
        proxy.populateClients();
 
        System.out.printf("Proxy %s: %d servidores, %d clientes%n",
                proxy.getIPv4(), proxy.getServers().size(), proxy.getClients().size());
 
        // Lista de todos os nomes existentes, só para a simulação sortear alvos
        List<String> existing = new ArrayList<>();

        for (Server s : proxy.getServers()) {
            existing.addAll(s.getFiles().keySet());
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<CompletableFuture<Response>> pending = new ArrayList<>();
 
        for (int i = 0; i < TOTAL_REQUESTS; i++) {
            Client client = proxy.getClients().get(random.nextInt(proxy.getClients().size()));
 
            // ~70% pedem arquivo existente, ~30% inexistente
            String file = random.nextInt(100) < 70
                    ? existing.get(random.nextInt(existing.size()))
                    : Integer.toHexString(random.nextInt()) + ".bin";
 
            // Simula um servidor caindo de vez em quando
            if (random.nextInt(100) < 2) {
                Server s = proxy.getServers().get(random.nextInt(proxy.getServers().size()));
                s.setStatus(s.isReachable() ? Status.DOWN : Status.UP);
            }
 
            Request request = client.createRequest(file);

            pending.add(proxy.handle(request).thenApply(response -> {
                System.out.println(response);
                return response;
            }));
 
            Thread.sleep(random.nextInt(0, 5));
        }
 
        CompletableFuture.allOf(pending.toArray(new CompletableFuture[0])).join();
 
        long ok = pending.stream().filter(f -> f.join().isOk()).count();
        long notFound = pending.stream()
                .filter(f -> f.join().getResult() == Response.Result.FILE_NOT_FOUND).count();
        
        System.out.printf("%nOK=%d  NOT_FOUND=%d  UNAVAILABLE=%d%n",
                ok, notFound, TOTAL_REQUESTS - ok - notFound);
 
        // Confere a integridade de uma transferência bem-sucedida
        pending.stream().map(CompletableFuture::join).filter(Response::isOk).findFirst().ifPresent(r -> {
            byte[] original = null;

            for (Server s : proxy.getServers()) {
                File f = s.getFiles().get(r.getRequest().getFileName());

                if (f != null) { 
                    original = f.getContent();
                    break;
                }
            }

            System.out.println("Integridade do 1º download: " + Arrays.equals(original, r.getContent()));
        });
 
        proxy.shutdown();
    }    
}
