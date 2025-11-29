class Solution {
    public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int x : nums) {
            if (first != null && x == first) continue;
            if (second != null && x == second) continue;
            if (third != null && x == third) continue;

            if (first == null || x > first) {
                third = second;
                second = first;
                first = (long)x;
            } 
            else if (second == null || x > second) {
                third = second;
                second = (long)x;
            } 
            else if (third == null || x > third) {
                third = (long)x;
            }
        }

        // If third maximum doesn't exist → return first (maximum)
        if (third == null) return first.intValue();

        return third.intValue();
    }
}
