class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, sum = 0, n = digits.length;
        for(int i=n-1; i>=0; i--) {
            sum = sum + digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
            sum = 0;
        }
        if(carry > 0) {
            int[] newArr = new int[n+1];
            newArr[0] = carry;
            for(int i=1; i<=n; i++) {
                newArr[i] = digits[i-1];
            }
            return newArr;
        } else {
            return digits;
        }
    }
}