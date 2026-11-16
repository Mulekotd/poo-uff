import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import utils.Container;
import utils.Utils;

public class ExercicioCollectionParaSet {
    public static void main(String[] args) {
        System.out.println("=== Questão 1 ===\n");

        List<String> frutas = new LinkedList<>();
        frutas.add("Banana");
        frutas.add("Melância");
        frutas.add("Banana");
        frutas.add("Uva");
        frutas.add("Banana");
        frutas.add("Maçã");

        Utils utils = new Utils();
        Set<String> f0 = utils.collectionToLinkedHashSet(frutas);
        Set<String> f1 = utils.collectionToHashSet(frutas);

        System.out.println("=== Coleção montada com LinkedHashSet ===");

        for (String fruta : f0) {
            System.out.println(fruta);
        }

        System.out.println("\n=== Coleção montada com HashSet ===");

        for (String fruta : f1) {
            System.out.println(fruta);
        }

        System.out.println("\n=== Questão 2 ===");

        Integer[] array = {1, 64, 256, 1, 1024};
        List<Integer> numeros = Arrays.asList(array);
        Set<Integer> n0 = utils.collectionToTreeSet(numeros);

        System.out.println("\n=== Coleção de números em ordem CRESCENTE ===");

        for (Integer numero : n0) {
            System.out.println(numero);
        }

        System.out.println("\n=== Questão 3 ===");

        Container c0 = new Container();
        Container c1 = new Container();
        Container c2 = new Container();
        Container c3 = new Container();

        Map<Integer, Container> m0 = new HashMap<Integer, Container>() {{
            put(c3.getId(), c3);
            put(c1.getId(), c1);
            put(c2.getId(), c2);
            put(c0.getId(), c0);
        }};

        System.out.println("\n=== Map de Objetos que implementam ModeloBase ===");
        System.out.println(m0.get(0));
        System.out.println(m0.get(1));
        System.out.println(m0.get(2));
        System.out.println(m0.get(3));
        System.out.println(m0.get(4)); // Deve imprimir null
    }
}
