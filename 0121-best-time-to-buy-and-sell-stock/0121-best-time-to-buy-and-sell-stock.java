class Solution {
    public int maxProfit(int[] prices) {
        return better(prices);
    }

    private static int better(int[] arr) {
        int ans = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            ans = Math.max(ans, arr[i] - minPrice);
        }
        return ans;
    }

    public int naive(int[] prices) {
        int ans = 0;
        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }

}