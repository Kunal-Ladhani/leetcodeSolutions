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
        
        if(isNeg || (s.charAt(startIdx) == '+')) {
            startIdx++;
        }
        
        while(startIdx < len && isNum(s.charAt(startIdx))) {
            int n = toNum(s.charAt(startIdx));
            
            // check for overflow
            if(Integer.MAX_VALUE / 10 < ans || Integer.MAX_VALUE / 10 == ans && Integer.MAX_VALUE % 10 < n)
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            ans = (ans*10) + n;
            startIdx++;
        }
        
        if(isNeg) {
            return -1 * ans;
        }
        
        return ans;
    }
    
    
    public int myAtoiq(String str) {
        int index = 0;
        int total = 0;
        int sign = 1;
        
        // Check if empty string
        if(str.length() == 0)
            return 0;
        
        // remove white spaces from the string
        while(index < str.length() && str.charAt(index) == ' ')
            index++;
        
        if (index == str.length()) return 0;
        
        // get the sign
        if(str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        
        // convert to the actual number and make sure it's not overflow
        while(index < str.length()) {
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            
            // check for overflow
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            total = total*10 + digit;
            index++; // don't forget to increment the counter
        }
        return total*sign;
    }
    
}