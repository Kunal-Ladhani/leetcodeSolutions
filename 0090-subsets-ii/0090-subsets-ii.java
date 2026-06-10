class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        // recUtil(nums, ans, new ArrayList<>(), 0);
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;    
    }
    // select and not select
    private static void recUtil(int[] nums, List<List<Integer>> ans, List<Integer> temp, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[idx]);
        recUtil(nums, ans, temp, idx+1);    // select

        temp.remove(temp.size()-1); // backtrack

        while (idx+1 < nums.length && nums[idx] == nums[idx+1])
            idx++;

        recUtil(nums, ans, temp, idx+1);    // not select
    }

    // backtracking soln
    private static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, int idx) {
        
        ans.add(new ArrayList<>(temp));
        
        for (int i = idx; i < nums.length; ++i) {
            if (i > idx && nums[i-1] == nums[i])
                continue;
            
            temp.add(nums[i]);
            backtrack(nums, ans, temp, i+1);  // select
            temp.remove(temp.size()-1); // backtrack
        }
    }

    
}