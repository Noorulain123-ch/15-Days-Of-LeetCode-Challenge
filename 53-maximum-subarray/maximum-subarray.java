public class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int best = Integer.MIN_VALUE; // handles all-negative arrays

        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur > best) best = cur;
            if (cur < 0) cur = 0;
        }
        return best;
    }

    // Optional main to test locally (not used by judges)
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums)); // prints 6
    }
}

