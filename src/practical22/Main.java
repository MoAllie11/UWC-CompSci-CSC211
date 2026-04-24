package practical22;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        try (Scanner sc = new Scanner(new File("test.txt"))) {
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(" ");
                String command = parts[0];

                switch (command) {
                    case "BUILD":
                        for (int i = 1; i < parts.length; i++) {
                            bst.insert(Integer.parseInt(parts[i]));
                        }
                        break;

                    case "IN_ORDER":
                        System.out.print("IN ORDER: ");
                        bst.printInOrder();
                        break;

                    case "INSERT":
                        bst.insert(Integer.parseInt(parts[1]));
                        break;

                    case "DELETE":
                        bst.delete(Integer.parseInt(parts[1]));
                        break;

                    case "SIZE":
                        System.out.println("SIZE: " + bst.size());
                        break;

                    case "HEIGHT":
                        System.out.println("HEIGHT: " + bst.height());
                        break;

                    case "KTH_SMALLEST":
                        int k = Integer.parseInt(parts[1]);
                        int val = bst.findKthSmallest(k);
                        if (val != -1) System.out.println("KTH SMALLEST: " + val + " (k = " + k + ")");
                        break;

                    case "SEARCH":
                        int searchVal = Integer.parseInt(parts[1]);
                        System.out.println("SEARCH " + searchVal + ": " + bst.search(searchVal));
                        break;

                    default:
                        System.out.println("Input not valid");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
