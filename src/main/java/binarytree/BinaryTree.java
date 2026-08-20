package binarytree;

public class BinaryTree {
    private static class Node {
        private int info;
        private Node left, right;

        public Node(int info) {
            this.info = info;
        }

        public int getInfo() {
            return this.info;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }
    }

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void inOrder() {
        _inOrder(this.root);
    }

    private void _inOrder(Node root) {
        if (root == null)
            return;

        _inOrder(root.getLeft());
        System.out.println(root.getInfo());
        _inOrder(root.getRight());
    }

    // Adiciona um valor mantendo a propriedade de árvore binária de busca.
    public void add(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }

        Node current = this.root;

        while (true) {
            if (value < current.info) {
                if (current.left == null) {
                    current.left = new Node(value);
                    return;
                }
                current = current.left;
            } else if (value > current.info) {
                if (current.right == null) {
                    current.right = new Node(value);
                    return;
                }
                current = current.right;
            } else {
                return;
            }
        }
    }
}
