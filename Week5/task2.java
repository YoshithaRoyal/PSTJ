import java.util.Scanner;

public class Solution {

    public static int birthday(int[] s, int d, int m) {
        int count = 0;

        if (s.length < m) return 0;

        // Sum of the first window
        int windowSum = 0;
        for (int i = 0; i < m; i++) {
            windowSum += s[i];
        }
        if (windowSum == d) count++;

        // Slide the window
        for (int i = m; i < s.length; i++) {
            windowSum += s[i] - s[i - m];
            if (windowSum == d) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of squares
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        int d = scanner.nextInt(); // Ron's birth day
        int m = scanner.nextInt(); // Ron's birth month

        int result = birthday(s, d, m);
        System.out.println(result);

        scanner.close();
    }
}
