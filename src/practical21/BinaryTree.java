//4590147
package practical21;

    public class BinaryTree<E>{
        private int size;
        private BinaryTreeNode<E> root;

        //default constructor
        public BinaryTree(){
            this.size = 0;
            this.root = null;
        }
        //loaded constructor
        public BinaryTree(BinaryTreeNode<E> root){
            this.root = root;
            this.size = 1;
        }
        //getters/setters
        public int getSize() { return size; }
        public void setSize(int size) { this.size = size; }
        public BinaryTreeNode<E> getRoot() { return root; }
        public void setRoot(BinaryTreeNode<E> root) { this.root = root; }

    }
