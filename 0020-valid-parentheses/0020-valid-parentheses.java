class Solution {
    private static boolean isMatching(char top, char bottom) {
        if (
            (top == '(' && bottom == ')') ||
            (top == '{' && bottom == '}') ||
            (top == '[' && bottom == ']')
        )
            return true;
        else
            return false;

    }

    public boolean isValid(String s) {
        int n = s.length(), count = 0;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        while(count < n) {
            char curr = s.charAt(count);
            if (List.of('(', '[', '{').contains(curr)) {
                stack.push(curr);
            } else {
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();
                if(!isMatching(top, curr))
                    return false;
            }
            count++;
        }

        if(!stack.isEmpty())
            return false;
        
        return true;
    }
}