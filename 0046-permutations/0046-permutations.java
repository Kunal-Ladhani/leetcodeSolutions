class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // order matters for permutation
        // all should be selected just in different order
        // at each position we have n options
        List<List<Integer>> ans = new ArrayList<>();
        recUtil(nums, new ArrayList<>(), ans);
        return ans;    
    }

    private static void recUtil(int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i=0; i<nums.length; ++i) {
            if (temp.contains(nums[i])) {   // this is overhead => costs O(k); k = selected elements
                continue;
            }

            temp.add(nums[i]);
            recUtil(nums, temp, ans);  // select
            temp.remove(temp.size()-1); // backtrack
        }

    }
}