package sistemaboleto;

public class Boleto {
    private final String id;
    private final String tipo;
    private final String cliente;
    private final Float subtotal;
    
    public Boleto(String id, String tipo, String cliente, Float subtotal) {
        this.id = id;
        this.tipo = tipo;
        this.cliente = cliente;
        this.subtotal = subtotal;
    }

    // Getters
    public String getId() {
        return this.id;
    }

    public String getTipo() {
        return this.tipo;
    }
    
    public String getCliente() {
        return this.cliente;
    }

    public Float getSubtotal() {
        return this.subtotal;
    }

    @Override
    public String toString() {
        return "Boleto{" +
               "id='" + id + '\'' +
               ", tipo='" + tipo + '\'' +
               ", cliente='" + cliente + '\'' +
               ", subtotal=" + subtotal +
               '}';
    }
}
