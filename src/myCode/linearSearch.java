package myCode;

public class linearSearch {
    public static void main(String[] args){
        int[] array = {2,5,8,9,3,6};
        int target = 5;
        int index = linearSearch(array,target);

        if(index != -1){
            System.out.println("Element found at index: " +index);
        } else{
            System.out.println("Element not found.");
        }
    }
    public static int linearSearch(int[] arr, int value){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == value){
                return i;
            }
        } return -1;
    }
}
