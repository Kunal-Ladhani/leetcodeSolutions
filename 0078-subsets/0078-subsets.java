class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recUtil(nums, 0, new ArrayList<>(), ans);    
        return ans;
    }

    private static void recUtil(int[] nums, int ptr, List<Integer> temp, List<List<Integer>> ans) {
        if (ptr == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        recUtil(nums, ptr+1, temp, ans);    // not select
        temp.add(nums[ptr]);
        recUtil(nums, ptr+1, temp, ans);    // select
        temp.remove(temp.size()-1);
    }
}