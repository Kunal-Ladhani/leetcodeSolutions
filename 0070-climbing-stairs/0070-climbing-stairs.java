class Solution {
    public int climbStairs(int n) {
        // return topdown(n);
        // return bottomup(n);
        return bottomup(n);
    }

    // top down dp
    private static int topdown(int n) {
        int[] dp = new int[n+1];
        topDownUtil(dp, n);
        return dp[n];
    }

    private static int topDownUtil(int[] dp, int n) {
        if (dp[n] == 0) {
            // recursively caluculate dp[n]
            if (n == 1 || n == 2)
                dp[n] = n;
            else
                dp[n] = topDownUtil(dp, n-1) + topDownUtil(dp, n-2);
        }
        return dp[n];
    }

    // bottom up dp
    private static int bottomup(int n) {
        if (n == 1 || n == 2)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    // space optimized
    private static int spaceopti(int n) {
        if (n == 1 || n == 2)
            return n;
        int prev1 = 1, prev2 = 2, curr = 0;
        for (int i=3; i<=n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}