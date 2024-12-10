class Solution {
    private static int[] getNextGreatestArray(int[] arr, int n) {
        if(n<=1)
            return arr;
        int[] nextGreatest = new int[n];
        nextGreatest[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--) {
            nextGreatest[i] = Math.max(nextGreatest[i+1],arr[i]);
        }
        return nextGreatest;
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] nextGreatest = getNextGreatestArray(prices, n);
        int maxProfit = 0;
        for(int i=0; i<n; i++) {
            maxProfit = Math.max(maxProfit, nextGreatest[i] - prices[i]);
        }
        return maxProfit;
    }
}