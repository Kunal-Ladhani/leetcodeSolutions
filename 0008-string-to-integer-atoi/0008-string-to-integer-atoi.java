class Solution {
    private static boolean isNum(char c) {
        if(c>='0' && c<='9') {
		    return true;
		}
        return false;
    }
    
    private static int toNum(char c) {
		return ((int)(c)-(int)('0'));
    }
    
    public int myAtoi(String s) {
        
        int ans = 0, startIdx = 0, len = s.length();
        
        // remove white spaces from the string
        while(startIdx < len && s.charAt(startIdx) == ' ') {
            startIdx++;
        }
        
        // means reached the end of string with no digits
        if(startIdx == len) {
            return 0;
        }
        
        boolean isNeg = (s.charAt(startIdx) == '-');
        
        // if + or - is there then skip that char
        if(isNeg || (s.charAt(startIdx) == '+')) {
            startIdx++;
        }
        
        // iterate till next non num char or end whichever comes first.
        while(startIdx < len && isNum(s.charAt(startIdx))) {
            int n = toNum(s.charAt(startIdx));
            
            // check for overflow
            if( Integer.MAX_VALUE / 10 < ans || // ans*10 + n will cause overflow in this case for any n
                (Integer.MAX_VALUE / 10 == ans && Integer.MAX_VALUE % 10 < n) // ans*10 will cause overflow if n > last dig of int_max
              ) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            ans = (ans*10) + n;
            startIdx++;
        }
        
        if(isNeg) {
            return -1 * ans;
        }
        
        return ans;
    }
}