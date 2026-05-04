//4590147
package practical23A;

public class practical23A {
    public static void print(int heap[]){
        int n = heap.length-1; //we start indexing at 1
        for (int i=1; i<=n; i++){ //iterates through the array
            System.out.print("Node " + heap[i] + " -> " ); //displays all nodes given
            boolean hasChild = false; //declare nodes to have no children (for now)
            for (int j=0; j<3; j++){
                int childIndex = 3*i - 1 + j; //condition for ternary heap children (i.e index 1 has children at indices 2,3,4)
                if (childIndex <= n){ //if there are children
                    System.out.print(heap[childIndex] + " "); //display the child(ren)
                    hasChild = true; //declare node to have a child
                }
            }
            if (!hasChild){ //if no children for any particular node
                System.out.print("No children"); //display that there are no children
            }
            System.out.println(); //clean display purposes
        }
    }
    public static int validate(int heap[]){
        int n = heap.length -1;
        boolean isMin = true, isMax = true; //declare definitions for min and max heaps (both true)
        for (int i=1; i<=n; i++){
            for (int j=0; j<3; j++){
                int childIndex = 3*i - 1 + j; //condition for children indices
                if (childIndex <= n){ //if there are children
                    if (heap[i] > heap[childIndex]) isMin = false; //not a min heap under this condition
                    if(heap[i] < heap[childIndex]) isMax = false; //not a max heap under this condition
                }
            }
        }
        if (isMin || isMax) return 1; //if either min or max condition satisfied -> valid heap
        return -1; //else not a valid heap
    }

    //testing with main method (min,max and invalid)
    public static void main(String[] args){
        int[] minHeap = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println("Min Heap:");
        print(minHeap);
        System.out.println("Validation: " + validate(minHeap));

        int[] maxHeap = {0,9,8,7,6,5,4,3,2,1,0};
        System.out.println("\nMax heap:");
        print(maxHeap);
        System.out.println("Validation: " + validate(maxHeap));

        int[] invalidHeap = {0,5,9,1,7,2};
        System.out.println("\nInvalid heap:");
        print(invalidHeap);
        System.out.println("Validation: " + validate(invalidHeap));

    }
}
