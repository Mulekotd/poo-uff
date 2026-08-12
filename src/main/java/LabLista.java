import list.List;

public class LabLista {
    public static void main(String[] args) 
    {
        List list = new List();
        
        list.add("Pizza");
        list.add("Lasagna");
        list.add("Pasta", 1);
        list.add("Hamburguer");

        list.println();

        System.out.println("Tamanho da lista " + list.size());
        System.out.println("Indice da Pizza " + list.index("Pizza"));

        list.add("Fettuccini");
        list.remove("Hamburguer");

        list.println();
    }
}
