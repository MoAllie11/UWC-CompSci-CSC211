package practical22;

class BinarySearchTree {
    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    //insert
    public void insert (int data){
        root = insertRec(root,data);
    }
    private Node insertRec(Node node, int data){
        if (node == null){
            size++;
            return new Node(data);
        }
        if (data < node.data) node.left = insertRec(node.left,data);
        else if (data > node.data) node.right = insertRec(node.right,data);
        else System.out.println("Input not valid.");
        return node;
    }

    //search
    public boolean search(int data){
        return searchRec(root,data);
    }
    private boolean searchRec(Node node, int data){
        if (node == null) return false;
        if (node.data == data) return true;
        return data < node.data ? searchRec(node.left, data) : searchRec(node.right, data);
    }

    //traversal
    public void printInOrder(){
        printInOrderRec(root);
        System.out.println();
    }
    private void printInOrderRec(Node node){
        if (node != null){
            printInOrderRec(node.left);
            System.out.print(node.data + " ");
            printInOrderRec(node.right);
        }
    }

    //height
    public int height(){
        return heightRec(root);
    }
    private int heightRec(Node node){
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left),heightRec(node.right));
    }

    //size
    public int size(){
        return size;
    }

    //find kth smallest
    public int findKthSmallest(int k) {
        if (k > size) {
            System.out.println("Input not valid");
            return -1;
        }
        return kthSmallestRec(root, new int[]{0}, k);
    }
    private int kthSmallestRec(Node node, int[] count, int k) {
        if (node == null) return -1;
        int left = kthSmallestRec(node.left, count, k);
        if (left != -1) return left;
        count[0]++;
        if (count[0] == k) return node.data;
        return kthSmallestRec(node.right, count, k);
    }

    //delete
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node node, int data) {
        if (node == null) {
            System.out.println("Input not valid");
            return null;
        }
        if (data < node.data) node.left = deleteRec(node.left, data);
        else if (data > node.data) node.right = deleteRec(node.right, data);
        else {
            // Node found
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            // Two children → use in-order predecessor
            node.data = maxValue(node.left);
            node.left = deleteRec(node.left, node.data);
            size--;
        }
        return node;
    }
    private int maxValue(Node node) {
        while (node.right != null) node = node.right;
        return node.data;
    }

    //isbalanced
    public void isBalanced() {
        System.out.println("unexpected input");
    }

}
