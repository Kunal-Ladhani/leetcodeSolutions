class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums;
        }
        
        int CONST = 1001;
        for(int i=0; i<n; i++) {
            
            // a = r + b*q
            // r -> a%q = r%q + bq%q = r + 0 = r
            // b -> a/q = r/q + bq/q = 0 + b = b
            nums[i] = nums[i] + (nums[nums[i]] % CONST) * CONST;
        }
        
        for(int i=0; i<n; i++) {   
            nums[i] = nums[i]/CONST;
        }
        
        return nums;
    }
    
    public int[] buildArray1(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums;
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = nums[nums[i]];
        }
        
        return ans;
    }
}