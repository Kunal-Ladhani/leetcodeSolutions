class Solution {
    private static boolean isOpening(char c) {
		return c == '{' || c == '(' || c == '[';
	}

	private static boolean isMatching(char top, char bracket) {
		return (top == '{' && bracket == '}') || (top == '(' && bracket == ')') || (top == '[' && bracket == ']');
	}

	private static boolean isBalanced(String s) {
		int n = s.length();
		if (n % 2 == 1)
			return false;
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			char bracket = s.charAt(i);
			if (isOpening(bracket)) {
				stack.push(bracket);
			} else {
				if (stack.isEmpty())
					return false;
				char topBracket = stack.pop();
				if (!isMatching(topBracket, bracket))
					return false;
			}
		}
		return stack.isEmpty();
	}

    public boolean isValid(String s) {
        return isBalanced(s);
    }
}