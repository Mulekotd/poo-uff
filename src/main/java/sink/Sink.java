package sink;

public interface Sink<T> {
    public void flush(T item);
}
