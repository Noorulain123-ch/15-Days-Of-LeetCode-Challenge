import java.util.*;

public class Solution {

    // memo to store already computed results
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        // key for memo
        String key = s1 + "|" + s2;
        if (memo.containsKey(key)) return memo.get(key);

        // base case
        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }

        // character check
        if (!sameChars(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();

        for (int i = 1; i < n; i++) {

            // 1 — no swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) 
            {
                memo.put(key, true);
                return true;
            }

            // 2 — with swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) 
            {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean sameChars(String a, String b) {
        int[] freq = new int[26];
        for (char c : a.toCharArray()) freq[c - 'a']++;
        for (char c : b.toCharArray()) freq[c - 'a']--;
        for (int f : freq) if (f != 0) return false;
        return true;
    }
}
