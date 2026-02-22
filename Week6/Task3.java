import java.util.*;

public class Solution {

    public static String twoStrings(String s1, String s2) {
        // Boolean array for lowercase letters
        boolean[] present = new boolean[26];
        
        // Mark characters present in s1
        for (int i = 0; i < s1.length(); i++) {
            present[s1.charAt(i) - 'a'] = true;
        }
        
        // Check if any character of s2 is present in s1
        for (int i = 0; i < s2.length(); i++) {
            if (present[s2.charAt(i) - 'a']) {
                return "YES";
            }
        }
        
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(twoStrings(s1, s2));
        }
        
        sc.close();
    }
}
