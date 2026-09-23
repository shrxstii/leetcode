class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        int length = nums.length;

        while (fast < length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow < length) {
            nums[slow] = 0;
            slow++;
        }
    }
}