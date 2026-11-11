package proxy;

import java.util.concurrent.ThreadLocalRandom;

public abstract class NetworkUtils {
    private static final String[] DNS_SERVERS = { "8.8.8.8", "1.1.1.1", "8.8.4.4" };

    public static String chooseDNS() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int index = random.nextInt(DNS_SERVERS.length);

        return DNS_SERVERS[index];
    }

    /**
     * Gera um IPv4 aleatório válido para unicast público,
     * evitando faixas reservadas (0, 10, 127, 169.254, 172.16-31, 192.168, 224+).
     */
    public static String generateIPv4() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int a, b;

        do {
            a = random.nextInt(1, 224); // 224+ é multicast/reservado
            b = random.nextInt(0, 256);
        } while (isReserved(a, b));

        int c = random.nextInt(0, 256);
        int d = random.nextInt(1, 255); // evita .0 (rede) e .255 (broadcast)

        return a + "." + b + "." + c + "." + d;
    }

    /**
     * Gera um IPv4 privado na faixa 192.168.x.x (ideal para simular uma rede interna).
     */
    public static String generatePrivateIPv4() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return "192.168." + random.nextInt(0, 256) + "." + random.nextInt(1, 255);
    }

    private static boolean isReserved(int a, int b) {
        return a == 10                                   // 10.0.0.0/8 (privada)
            || a == 127                                  // loopback
            || (a == 169 && b == 254)                    // link-local
            || (a == 172 && b >= 16 && b <= 31)          // 172.16.0.0/12  (privada)
            || (a == 192 && b == 168);                   // 192.168.0.0/16 (privada)
    }
}
