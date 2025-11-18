import java.util.Scanner;

public class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int[] f = new int[256];
        int l = 0, ans = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            f[c]++;
            while (f[c] > 1) {
                f[s.charAt(l)]--;
                l++;
            }
            int len = r - l + 1;
            if (len > ans) ans = len;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
