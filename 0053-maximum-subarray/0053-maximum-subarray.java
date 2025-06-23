class Solution {
    public int maxSubArray(int[] nums) {
        // corner cases
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int maxSubArraySum = Integer.MIN_VALUE, runningSum = 0;
        for (int i=0; i<n; ++i) {
            runningSum += nums[i];
            if (runningSum > maxSubArraySum) {
                maxSubArraySum = runningSum;
            }
            if (runningSum < 0) {
                runningSum = 0;
            }
            // runningSum = Math.max(runningSum + nums[i], nums[i]);
            // maxSubArraySum = Math.max(maxSubArraySum, runningSum);
        }
        return maxSubArraySum;
    }
}