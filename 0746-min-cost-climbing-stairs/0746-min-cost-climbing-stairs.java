class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // return naive(cost);
        // return topdown(cost);
        // return bottomUp(cost);
        return spaceOpti(cost);
    }

    // naive soln - recursion
    private static int naive(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n-1), minCost(cost,n-2));
    }

    private static int minCost(int[] cost, int step) {
        if (step == 0 || step == 1) {
            return cost[step];
        }
        return cost[step] + Math.min(minCost(cost, step-1), minCost(cost, step-2));
    }
 
    // top down dp
    private static int topdown(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        return Math.min(topDownUtil(dp, cost, n-1), topDownUtil(dp, cost, n-2));
    }

    private static int topDownUtil(int[] dp, int[] cost, int step) {
        if (dp[step] == 0) {
            if (step == 0 || step == 1)
                dp[step] = cost[step];
            else
                dp[step] = cost[step] + Math.min(topDownUtil(dp, cost, step-1), topDownUtil(dp, cost, step-2));
        }
        return dp[step];
    }

    // bottom up
    private static int bottomUp(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }

    // space optimization
    private static int spaceOpti(int[] cost) {
        int n = cost.length;
        int prev1 = cost[0];
        int prev2 = cost[1];
        if (n == 2)
            return Math.min(prev1, prev2);

        int curr = -1;
        for (int i=2; i<n; ++i) {
            curr = cost[i] + Math.min(prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }

        return Math.min(curr, prev1);
    }

}