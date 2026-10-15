package sink;

import java.util.Collection;

public abstract class SinkUtils {
    public static <T> T writeAll(Collection<T> collection, Sink<? super T> sink) {
        T last = null;

        for (T item : collection) {
            last = item;
            sink.flush(last);
        }

        return last;
    } 
}
