class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];   // frequency of each letter

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;   // count in s
            freq[t.charAt(i) - 'a']--;   // subtract count in t
        }

        for (int f : freq) {
            if (f != 0) return false;    // mismatch found
        }

        return true;
    }
}
