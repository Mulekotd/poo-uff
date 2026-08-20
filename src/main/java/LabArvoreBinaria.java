import binarytree.BinaryTree;

public class LabArvoreBinaria {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
 
        binaryTree.add(10);
        binaryTree.add(50);
        binaryTree.add(5);
        binaryTree.add(25);
        binaryTree.add(20);

        binaryTree.inOrder();
    }
}
