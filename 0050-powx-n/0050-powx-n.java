class Solution {
    public double myPow(double x, int n) {
        return helper(x, (long)n);
    }

    private double helper(double x, long n) {
        if (n == 0 && x != 0) {
            return 1.0d;
        }    
        if (x == 1 || x == 0) {
            return x;
        } 

        if (n < 0) {
            x = 1/x;
            n = -1 * n;
        }

        double temp;
        if (n % 2 == 0) {
            temp = helper(x, n/2);
            return temp * temp;
        } 

        temp = helper(x, (n-1)/2);
        return x * temp * temp;
    }
}