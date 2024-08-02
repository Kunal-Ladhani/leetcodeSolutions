class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0.0;
        if(n == 0) return 1.0;
        if (n == Integer.MAX_VALUE) return (x == 1) ? 1 : (x == -1) ? -1 : 0;
        if (n == Integer.MIN_VALUE) return (x == 1 || x == -1) ? 1 : 0;
        
        if(n == 1) return x;
        else if (n > 1) {
            if(n%2 == 0) {
                double k = myPow(x,n/2);
                return k * k;
            } else {
                double p = myPow(x,(n-1)/2);
                return p * p * x;
            }
        } else {
            n = n * -1;
            if(n%2 == 0) {
                double k = myPow(x,n/2);
                return 1/(k * k);
            } else {
                double p = myPow(x,(n-1)/2);
                return 1/(p * p * x);
            }
        }
    }
}