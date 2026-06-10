class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // build freq array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; ++i)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

        // Arrays.sort(nums);
        // boolean[] used = new boolean[nums.length];
        // recUtil(nums, used, new ArrayList<>(), ans);

        backtrack(nums.length, map, new ArrayList<>(), ans);
        return ans;        
    }

    private static void recUtil(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i=0; i<nums.length; ++i) {
            if (used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }

            used[i] = true;
            temp.add(nums[i]);
            
            recUtil(nums, used, temp, ans);

            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }

    private void backtrack(int n, Map<Integer, Integer> freq, List<Integer> curr, List<List<Integer>> result) {

        if (curr.size() == n) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int num : freq.keySet()) {

            if (freq.get(num) == 0) {
                continue;
            }

            curr.add(num);
            freq.put(num, freq.get(num) - 1);

            backtrack(n, freq, curr, result);

            curr.remove(curr.size() - 1);
            freq.put(num, freq.get(num) + 1);
        }
    }

}
