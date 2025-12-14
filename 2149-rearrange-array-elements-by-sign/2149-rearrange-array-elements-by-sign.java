class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= 0) {
                positives.add(nums[i]);
            } else {
                negatives.add(nums[i]);
            }
        }

        int p = 0, n = 0;
        for (int i=0; i<nums.length; i++) {
            if (i%2 == 0) {
                nums[i] = positives.get(p++);
            } else {
                nums[i] = negatives.get(n++);
            }
        }

        return nums;
    }
}