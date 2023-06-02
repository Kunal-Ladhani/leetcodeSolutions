class Solution {
    // TC = O(N)
    // SC = O(1)
    public int removeDuplicates(int[] nums) {
        int i = 0, n = nums.length;
        for(int j=1; j<n; j++) {
            if(nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }        
        return i+1;
    }
    
    // TC = O(N)
    // SC = O(N)
    private int removeDuplicatesUsingHashSet(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
            hs.add(nums[i]);
        }
        return hs.size();
    }
}