package proxy;

import java.util.concurrent.atomic.AtomicInteger;
 
public class Request {
    private static final AtomicInteger NEXT_ID = new AtomicInteger();
 
    private final int id;
    private final Session session;
    private final String fileName;
 
    public Request(Session session, String fileName) {
        this.id = NEXT_ID.getAndIncrement();
        this.session = session;
        this.fileName = fileName;
    }
 
    // Getters
 
    public int getId() { return this.id; }
    public Session getSession() { return this.session; }
    public Client getClient() { return this.session.getClient(); }
    public String getFileName() { return this.fileName; }
 
    @Override
    public String toString() {
        return "Request#" + id + " [client=" + getClient().getIPv4()
                + ", session=" + session.getId() + ", file=" + fileName + "]";
    }
}
