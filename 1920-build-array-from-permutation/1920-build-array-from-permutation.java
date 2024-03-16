class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums;
        }
        
        // CONST -> n to infinity anthing nore than n-1, as size of arr is n
        int CONST = n;
        
        // a = r + b*q
        for(int i=0; i<n; i++) {
            
            // r -> a%q = r%q + bq%q = r + 0 = r
            int r = nums[i];
            
            // b -> a/q = r/q + bq/q = 0 + b = b
            int b = nums[nums[i]] % CONST;
            
            // put it together => r+bq = a
            nums[i] = r + b * CONST;
        }
        
        // extract b from it
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

