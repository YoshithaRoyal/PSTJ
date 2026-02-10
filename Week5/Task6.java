import java.util.Scanner;

public class Solution {

    // Function to calculate minimum deletions
    public static int alternatingCharacters(String s) {
        int deletions = 0;

        // Scan the string from the second character
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++; // Count this duplicate
            }
        }

        return deletions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // Number of queries
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < q; i++) {
            String s = scanner.nextLine();
            System.out.println(alternatingCharacters(s));
        }

        scanner.close();
    }
}
