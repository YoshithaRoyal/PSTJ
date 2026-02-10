import java.util.Scanner;

public class Solution {

    public static int[] maxSubarray(int[] arr) {
        int maxSubarray = arr[0]; // max contiguous sum
        int currentMax = arr[0];

        int maxSubsequence = arr[0]; // max non-contiguous sum
        int sumPositives = arr[0] > 0 ? arr[0] : 0;

        for (int i = 1; i < arr.length; i++) {
            // Kadane's algorithm for max subarray
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSubarray = Math.max(maxSubarray, currentMax);

            // For max subsequence
            if (arr[i] > 0) {
                sumPositives += arr[i];
            }
            maxSubsequence = Math.max(maxSubsequence, arr[i]); // in case all numbers are negative
        }

        // If there are positive numbers, sum them; else, use the largest number
        if (sumPositives > 0) {
            maxSubsequence = sumPositives;
        }

        return new int[]{maxSubarray, maxSubsequence};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // size of array
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            int[] result = maxSubarray(arr);
            System.out.println(result[0] + " " + result[1]);
        }

        scanner.close();
    }
}
