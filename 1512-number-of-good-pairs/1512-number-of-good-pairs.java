class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> e : freq.entrySet()) {
            int k = e.getValue();
            if(k >= 2) {
                ans += (k*(k-1))/2;
            }
        }
        return ans;
    }
}