class Solution {
    private boolean isOpeningBracket(char bkt) {
        return (bkt == '[' || bkt == '{' || bkt == '('); 
    }
    
    private boolean isMatchingBracket(char bkt1, char bkt2) {
        return (
            (bkt1 == '[' && bkt2 == ']') ||
            (bkt1 == '{' && bkt2 == '}') ||
            (bkt1 == '(' && bkt2 == ')')
        );     
    }
    
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<n; i++) {
            char bkt = s.charAt(i);
            if(isOpeningBracket(bkt)) {
                stk.push(bkt);
            } else {
                if(stk.size() != 0) {
                    char top = stk.pop();
                    if(!isMatchingBracket(top,bkt)) {
                        return false;
                    }                    
                } else {
                    return false;
                }
            }
        }
        if(stk.size() != 0) {
            return false;
        }
        return true;
    }
}