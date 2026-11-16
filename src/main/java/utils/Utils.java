package utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Utils {
    // Remove duplicatas e preserva a ordem de iteração da coleção recebida.
    public <E> Set<E> collectionToLinkedHashSet(Collection<E> c) {
        return new LinkedHashSet<>(c);
    }

    // Remove duplicatas, mas não garante nenhuma ordem de iteração.
    public <E> Set<E> collectionToHashSet(Collection<E> c) {
        return new HashSet<>(c);
    }

    // Remove duplicatas e retorna os elementos em sua ordem natural crescente.
    public <E> Set<E> collectionToTreeSet(Collection<E> c) {
        return new TreeSet<>(c);
    }
}
