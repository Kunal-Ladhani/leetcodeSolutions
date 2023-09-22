class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
//         int n = nums.length, c = 0;
//         int[] ans = new int[n];
        
//         // TC = O(N) SC = O(1) excluding the space for answer
//         Arrays.sort(nums);  
        
//         for(int i=0; i<n; i++) {
                    
//         }
        
//         return ans;
//     }
    
//     public int[] trivialSolution(int[] nums) {
        int n = nums.length, c = 0;
        int[] ans = new int[n];
        
        // TC = O(N^2) SC = O(1) excluding the space for answer
        for(int i=0; i<n; i++) {
            c = 0;
            for(int j=0; j<n; j++) {
                if(i != j && nums[j] < nums[i]) {
                    c++;
                }
            }
            ans[i] = c;
        }
        return ans;
    }
}