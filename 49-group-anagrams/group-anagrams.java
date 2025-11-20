import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        boolean[] used = new boolean[strs.length];

        // using LinkedList instead of ArrayList
        List<List<String>> ans = new LinkedList<>();

        for (int i = 0; i < strs.length; i++) {

            if (used[i]) continue;

            List<String> group = new LinkedList<>();
            group.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!used[j] && check(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }

            ans.add(group);
        }

        return ans;
    }

    private boolean check(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] f = new int[26];

        for (int i = 0; i < a.length(); i++) {
            f[a.charAt(i) - 'a']++;
            f[b.charAt(i) - 'a']--;
        }

        for (int x : f) {
            if (x != 0) return false;
        }

        return true;
    }
}
