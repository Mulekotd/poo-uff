package proxy;
 
public class Response {
    public enum Result {
        OK,                   // arquivo encontrado e transferido por completo
        FILE_NOT_FOUND,       // nenhum servidor do Cloud possui o arquivo
        SERVER_UNAVAILABLE    // o servidor com o arquivo está DOWN (ou caiu durante a transferência)
    }
 
    private final Request request;
    private final Result result;
    private final String serverIPv4;
    private final byte[] content;
    private final long bitsTransferred;
    private final long elapsedNanos;
 
    public Response(Request request, Result result, String serverIPv4,
                    byte[] content, long bitsTransferred, long elapsedNanos) {
        this.request = request;
        this.result = result;
        this.serverIPv4 = serverIPv4;
        this.content = content;
        this.bitsTransferred = bitsTransferred;
        this.elapsedNanos = elapsedNanos;
    }
 
    // Getters
 
    public Request getRequest() { return this.request; }
    public Result getResult() { return this.result; }
    public String getServerIPv4() { return this.serverIPv4; }
    public byte[] getContent() { return this.content == null ? null : this.content.clone(); }
    public long getBitsTransferred() { return this.bitsTransferred; }
    public long getElapsedNanos() { return this.elapsedNanos; }
    public boolean isOk() { return this.result == Result.OK; }
 
    @Override
    public String toString() {
        return "Response to " + request.getClient().getIPv4() + " [" + result
                + (serverIPv4 != null ? ", server=" + serverIPv4 : "")
                + ", bits=" + bitsTransferred
                + ", " + (elapsedNanos / 1000) + " µs]";
    }
}
