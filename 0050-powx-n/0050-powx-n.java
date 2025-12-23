class Solution {

    /**
        pow(x,n) = x^n = 
        
        we have 2 options here -

        n == odd 
        => n = 2k+1
        pow(x,n) = pow(x,n/2) * pow(x,n/2) * x 

        n == even 
        => n = 2k
        pow(x,n) = pow(x,n/2) * pow(x,n/2)
    */
    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }

    private static double binaryExp(double x, long n) {
        if (n == 0)
            return 1.0d;
        
        if (n == 1)
            return x;
        
        if (n < 0) {
            x = (double) 1/x;
            n = -1 * n;
        }

        double half;
        if (n%2 == 0) {
            half = binaryExp(x, n/2);            
            return half * half;            
        }

        half = binaryExp(x, (n-1)/2);   
        return half * half * x;
    }
}