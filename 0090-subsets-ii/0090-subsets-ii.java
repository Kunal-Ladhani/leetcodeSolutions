class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    private static void helper(int[] nums, int ptr, List<Integer> temp, Set<List<Integer>> ans) {
        if (ptr == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        helper(nums, ptr + 1, temp, ans);   // not select
        temp.add(nums[ptr]);
        helper(nums, ptr + 1, temp, ans);   // not select
        temp.remove(temp.size()-1);     // backtrack        
    }
}