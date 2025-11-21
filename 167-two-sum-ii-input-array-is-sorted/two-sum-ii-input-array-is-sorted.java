class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;                 // first pointer
        int j = nums.length - 1;   // second pointer

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == target) {
                return new int[]{i + 1, j + 1};  
            }
            else if (sum < target) {
                i++;   // move left pointer right
            }
            else {
                j--;   // move right pointer left
            }
        }

        return new int[]{-1, -1};  // (will never happen because one solution always exists)
    }
}
