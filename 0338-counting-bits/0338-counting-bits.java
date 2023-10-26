class Solution {
    private int countSetBits(int n) {
        if(n == 0) {
            return 0;
        }
        
        int carry = 0, count = 0;
        
        while(n > 0) {
            if(carry == 1) {
                count++;
            }
            carry = n%2;
            n = n/2;
        }
        
        if(carry == 1) {
            count++;
        }
        
        return count;
    }
    
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i=0; i<=n; ++i) {
            ans[i] = countSetBits(i);
        }
        
        return ans;
    }
}