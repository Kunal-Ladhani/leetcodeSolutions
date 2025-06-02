class Solution {
    private static int countSetBits(int n) {
        int ans = 0;
        while (n > 0) {
            n = n & n-1;
            ans++;
        }
        return ans;
    }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i=0; i<=n; i++) {
            ans[i] = countSetBits(i);
        }
        return ans;
    }
}