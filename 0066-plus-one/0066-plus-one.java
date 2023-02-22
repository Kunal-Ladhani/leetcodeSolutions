class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        int[] ans;
        for(int i=n-1; i>=0; --i) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] = digits[i]%10;
        }
        if(carry > 0) {
            ans = new int[n+1];
            ans[0] = carry;
            for(int i=0; i<n; i++) {
                ans[i+1] = digits[i];
            }
            return ans;
        } else {
            return digits;
        }
    }
}