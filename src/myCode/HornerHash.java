package myCode;

public class HornerHash {
    public static int charToValue(char c){
        if (Character.isDigit(c)){
            return c - '0';
        } else {
            return Character.toLowerCase(c) - 'a' + 10;
        }
    }
    //Hash function using Horner's Rule with mod m
    public static int h(int x, String A, int m){
        int result = 0;

        for (int i=0; i<A.length(); i++){
            int digit = charToValue(A.charAt(i));
            result = (result*x + digit)%m;
        }
        return result +1; //shift from [0..m-1] to [1..m]
    }
    public static void main(String[] args){
        System.out.println(h(2, "10000000000", 137));
        System.out.println(h(8, "7777", 137));
        System.out.println(h(10, "123456789", 137));
        System.out.println(h(37, "something", 137));
    }
}
