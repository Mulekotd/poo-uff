import list.List;

public class LabLista {
    public static void main(String[] args) 
    {
        List list = new List();
        
        list.add("Spaghetti");
        list.add("Lasagna");
        list.add("Pizza");

        list.println();

        list.add("Fettuccini", 0);
        list.remove("Pizza");

        list.println();

        System.out.println("Tamanho da lista " + list.size());
    }
}
