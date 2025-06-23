class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i]-min);
        }   
        return ans;
    }
}