class Solution {
    private int countSetBits(int n) {
        if(n == 0) {
            // edge case - 0 has no set bits
            return 0;    
        }
        // count is num of set bits
        int carry = 0, count = 0;
        
        while(n > 0) {
            if(carry == 1) {
                count++;
            }
            carry = n%2;
            n = n/2;
        }
        // last MSB is not checked in that loop
        if(carry == 1) {
            count++;
        }
        
        return count;
    }
    
    
    
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        int n = nums.size();
        
        for(int i=0; i<n; i++) {
            // true if count of set bits in n == k else falss
            if(countSetBits(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }
}