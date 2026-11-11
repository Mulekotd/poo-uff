package proxy;
 
import java.util.concurrent.atomic.AtomicInteger;
 
public class Session {
    private static final AtomicInteger NEXT_ID = new AtomicInteger();
 
    private final int id;
    private final Client client;
 
    public Session(Client client) {
        this.id = NEXT_ID.getAndIncrement();
        this.client = client;
    }
 
    // Getters
 
    public int getId() {
        return this.id;
    }
    
    public Client getClient() {
        return this.client;
    }
}
