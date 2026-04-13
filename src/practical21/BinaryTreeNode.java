//4590147
package practical21;

    public class BinaryTreeNode<E>{
        private E value;
        private BinaryTreeNode<E> left;
        private BinaryTreeNode<E> right;
        //default constructor
        public BinaryTreeNode(){
            this.value = null;
            this.left = null;
            this.right = null;
        }
        //loaded constructor
        public BinaryTreeNode(E value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
        //getters/setters
        public E getValue() {return value;}
        public void setValue(E value) {this.value = value;}
        public BinaryTreeNode<E> getLeft() {return left;}
        public void setLeft(BinaryTreeNode<E> left) {this.left=left;}
        public BinaryTreeNode<E> getRight() {return right;}
        public void setRight(BinaryTreeNode<E> right) {this.right=right;}
    }

