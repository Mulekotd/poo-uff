package list;

import java.util.Objects;

public class List {
    private static class Node {
        private Object info;
        private Node next;

        public Node(Object info, Node next) {
            this.info = info;
            this.next = next;
        }

        public Object getInfo() {
            return this.info;
        }

        public void setInfo(Object info) {
            this.info = info;
        }
    }

    public Node head;
    public Node tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    // Adiciona um objeto ao final da lista
    public void add(Object o) {
        Node node = new Node(o, null);
        
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    // Adiciona o objeto na posição indicada
    public void add(Object o, int index) {
        if (index == 0) {
            Node node = new Node(o, this.head);
            this.head = node;

            if (this.tail == null) {
                this.tail = node;
            }

            return;
        }

        Node current = this.head;

        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        Node node = new Node(o, current.next);
        current.next = node;

        if (node.next == null) {
            this.tail = node;
        }
    }

    // Retorna um valor booleano correspondente a existência do objeto na lista
    public boolean has(Object o) {
        for (Node current = this.head; current != null; current = current.next) {
            if (Objects.equals(current.getInfo(), o)) {
                return true;
            }
        }

        return false;
    }

    // Proucura por um objeto e retorna ele
    public Object get(Object o) {
        for (Node current = this.head; current != null; current = current.next) {
            if (Objects.equals(current.getInfo(), o)) {
                return current.getInfo();
            }
        }

        return null;
    }

    // Remove o objeto caso exista
    public Object remove(Object o) {
        Node previous = null;

        for (Node current = this.head; current != null; current = current.next) {
            if (Objects.equals(current.getInfo(), o)) {
                if (previous == null) {
                    this.head = current.next;
                } else {
                    previous.next = current.next;
                }

                if (current == this.tail) {
                    this.tail = previous;
                }

                return current.getInfo();
            }

            previous = current;
        }

        return null;
    }

    // Retorna a posição do objeto caso esteja na lista
    public int find(Object o) {
        int index = 0;

        for (Node current = this.head; current != null; current = current.next) {
            if (this.has(o)) {
                break;
            }

            index++;
        }

        return index;
    }

    // Imprime o conteúdo da lista
    public void println() {
        for (Node current = this.head; current != null; current = current.next) {
            System.out.println(current.getInfo());
        }
    }

    // Retorna o tamanho da lista
    public int size() {
        int count = 0;

        for (Node current = this.head; current != null; current = current.next) {
            count++;
        }

        return count;
    }
}
