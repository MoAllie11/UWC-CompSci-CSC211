//4590147
package practical21;
public class Main {
    public static void main(String[] args) {
        //first tree
        BinaryTreeNode<String> root1 = new BinaryTreeNode<>("a");
        root1.setLeft(new BinaryTreeNode<>("b"));
        root1.setRight(new BinaryTreeNode<>("c"));
        root1.getLeft().setLeft(new BinaryTreeNode<>("d"));
        root1.getLeft().setRight(new BinaryTreeNode<>("e"));

        BinaryTree<String> bt1 = new BinaryTree<>(root1);

        //second tree
        BinaryTreeNode<Double> root2 = new BinaryTreeNode<>(3.4);
        root2.setLeft(new BinaryTreeNode<>(-1.5));
        root2.setRight(new BinaryTreeNode<>(2.9));
        root2.getLeft().setLeft(new BinaryTreeNode<>(-9.3));

        BinaryTree<Double> bt2 = new BinaryTree<>(root2);

        //output
        System.out.println("bt1 root: " + bt1.getRoot().getValue());
        System.out.println("bt2 root: " + bt2.getRoot().getValue());
    }
}
