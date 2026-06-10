class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        recUtil(candidates, ans, target, 0, new ArrayList<>());           
        return ans;     
    }

    private static void recUtil(int[] candidates, List<List<Integer>> ans, int target, int idx, List<Integer> temp) {
        if (target < 0)
            return;
        
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i=idx; i<candidates.length; ++i) {
            if (i > idx && candidates[i-1] == candidates[i]) 
                continue;
            
            temp.add(candidates[i]);
            recUtil(candidates, ans, target-candidates[i], i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}