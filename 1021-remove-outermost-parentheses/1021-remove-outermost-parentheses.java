class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i=0; i<s.length(); i++) {
            // we will push only
            Character bracket = s.charAt(i);
            if (bracket == '(') {
                if (!stack.isEmpty()) {
                    sb.append(bracket);    
                }
                stack.push(bracket);
            } else {
                Character top = stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(bracket);
                }
            }
        }

        return sb.toString();
    }
}