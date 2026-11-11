package proxy;
 
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
 
public class Server {
    private static final int MIN_FILES = 1;
    private static final int MAX_FILES = 255;
 
    private final String dns;
    private final String ipv4;
    private volatile Status status;
 
    private final Map<String, File> files;
 
    public Server() {
        this.dns = NetworkUtils.chooseDNS();
        this.ipv4 = NetworkUtils.generateIPv4();
        this.status = Status.UP;
 
        this.files = new HashMap<>();
        this.populate();
    }
 
    private void populate() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int total = random.nextInt(MIN_FILES, MAX_FILES + 1);
 
        while (this.files.size() < total) {
            File file = new File();
            this.files.putIfAbsent(file.getName(), file);
        }
    }
 
    // Getters
 
    public String getDNS() { return this.dns; }
    public String getIPv4() { return this.ipv4; }
    public Status getStatus() { return this.status; }
 
    public Map<String, File> getFiles() {
        return Collections.unmodifiableMap(this.files);
    }
 
    public int getFileCount() {
        return this.files.size();
    }
 
    // Setters
 
    public void setStatus(Status status) { this.status = status; }
 
    // Methods
 
    public boolean isReachable() {
        return this.getStatus().equals(Status.UP);
    }
}
