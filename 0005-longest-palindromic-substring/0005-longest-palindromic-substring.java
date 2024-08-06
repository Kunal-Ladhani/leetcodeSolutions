class Solution {
    private static String expand(String s, int N, int l, int r) {
        while(l>=0 && r<N && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
        
    }
    
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) {
            return s;
        }
        String ans = s.substring(0,1);
        int max_len = ans.length();
        // even len string
        // center will be in between
        for(int i=0; i<n; i++) {
            String str = expand(s,n,i,i+1);
            if(str.length() >ans.length()) {
                ans = str;
                max_len = ans.length();
            }
        }
        
        // odd length string
        // center will be a char
        for(int i=0; i<n; i++) {
            String str = expand(s,n,i-1,i+1);
            if(str.length() >ans.length()) {
                ans = str;
                max_len = ans.length();
            }
        }
        
        return ans;
    }
    
    
    
}