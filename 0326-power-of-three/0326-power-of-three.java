class Solution {
    public boolean isPowerOfThree(int n) {
        // base case
        if (n == 1 || n == 3)
            return true;

        // discounting -ve numbers
        if (n <= 0)
            return false;

        int q = n/3;
        int r = n%3;

        if (r != 0)
            return false;

        return isPowerOfThree(q);
    }
}