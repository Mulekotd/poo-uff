import java.util.ArrayList;
import java.util.Collection;
import sink.Sink;
import sink.SinkUtils;

public class ProgramaSink {
    public static void main(String[] args) {
        Collection<String> cs = new ArrayList<>();
        cs.add("Paçoca");
        cs.add("Suspiro");
        cs.add("Pé-de-moleque");

        Sink<Object> sink = (value) -> System.out.println(value);
        
        SinkUtils.writeAll(cs, sink);
    }
}
