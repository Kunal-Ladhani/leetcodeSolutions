class Solution {
    public double naive(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n<0)
            return (double)(1/myPow(x,Math.abs(n)));

        double ans = myPow(x, n/2);
        if (n%2 == 0)
            return ans * ans;
        else
            return x * ans * ans;
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }
}