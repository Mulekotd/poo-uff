package proxy;

public class Client {
    private final String ipv4;
    private final Session session;
 
    public Client() {
        this.ipv4 = NetworkUtils.generateIPv4();
        this.session = new Session(this);
    }
 
    // Methods
 
    /** Cria uma requisição pelo arquivo informado, associada à sessão deste cliente. */
    public Request createRequest(String fileName) {
        return new Request(this.session, fileName);
    }
 
    // Getters
 
    public String getIPv4() {
        return this.ipv4;
    }
 
    public Session getSession() {
        return this.session;
    }
}
 