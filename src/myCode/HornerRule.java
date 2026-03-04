package myCode;

public class HornerRule {
    //Converts a char to its numeric value
    //Works for digits and letters (for bases > 10)
    public static int charToValue(char c){
        if (Character.isDigit(c)){
            return c - '0'; //***
        } else{
            return Character.toLowerCase(c) - 'a' + 10; //**
        }
    }
    //Horner's Rule function
    public static long P(int x, String A){
        long result = 0;
        for (int i=0; i<A.length(); i++){
            int digit = charToValue(A.charAt(i));
            result = result*x + digit;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(P(2, "10000000000"));
        System.out.println(P(8, "777"));
        System.out.println(P(10, "123456789"));
        System.out.println(P(37, "something"));
    }
}
