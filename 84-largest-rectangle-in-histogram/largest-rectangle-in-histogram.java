class Solution {
    public static int gpt(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        // Iterate over each bar
        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];

            // Expand the window to find max rectangle including heights[i]
            for (int j = i+1; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                int area = minHeight * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static int claude(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        
        while (i < n) {
            // If stack is empty or current bar is higher than the bar at stack top,
            // push current bar to stack and move to next bar
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                // If current bar is lower than the bar at stack top,
                // calculate area with the stack top as the lowest bar
                int topIndex = stack.pop();
                
                // Calculate the area with heights[topIndex] as the lowest bar
                // Width is determined by the current position and the position of the previous bar in stack
                int area = heights[topIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                
                // Update maximum area if needed
                maxArea = Math.max(maxArea, area);
            }
        }
        
        // Process remaining bars in the stack
        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            int area = heights[topIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }

    private static int naive(int[] arr, int n) {
        int ans = 0;

        for (int i=0; i<n; i++) {
            int curr = arr[i];
            // go left side
            for (int j=i-1; j>=0; j--) {
                if (arr[j] < arr[i])
                    break;
                curr += arr[i];
            }
            // go right side
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[i])
                    break;
                curr += arr[i];
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    private static int[] prevSmallerElement(int[] arr, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerElement(int[] arr, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        // int n = heights.length, ans = 0, h = 0, w = 0, area = 0;
        // if (n == 0)
        //     return ans;
        // int[] next = nextSmallerElement(heights, n);
        // int[] prev = prevSmallerElement(heights, n);
        // for(int i=0; i<n; i++) {
        //     h = heights[i];
        //     w = next[i] - prev[i] - 1;
        //     area = h * w;
        //     ans = Math.max(ans, area); 
        // }

        return gpt2(heights);
    }

    public int gpt2(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // At i == n, we process all remaining elements in the stack
            int h = (i == n) ? 0 : heights[i];

            // Process elements in the stack if the current height is smaller
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];  // Get the height of the rectangle
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;  // Calculate width
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);  // Push the current index onto the stack
        }

        return maxArea;
    }
}