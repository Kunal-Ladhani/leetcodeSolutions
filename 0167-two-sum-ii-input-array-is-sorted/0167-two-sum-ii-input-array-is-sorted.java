class Solution {

    public int[] twoSumUnsorted(int[] nums, int target) {
        int[] ans = new int[2];

        // O(N) SC
        Map<Integer, Integer> map = new HashMap<>();

        // O(N) TC
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                ans[0] = map.get(complement) + 1;
                ans[1] = i + 1;
                return ans;
            }
            map.put(nums[i], i);
        }

        return ans;
    }

    public int[] twoSumSorted(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        // O(1) SC

        // O(N) TC
        for (int i = 0, j = n - 1; i < j;) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }

    public int[] twoSum(int[] arr, int t) {
        // return twoSumUnsorted(arr,t);
        return twoSumSorted(arr, t);
    }
}