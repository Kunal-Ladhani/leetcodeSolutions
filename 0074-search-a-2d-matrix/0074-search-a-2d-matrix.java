class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        
        // corner case that it is smaller than smallest or larger than largest
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }

        // return naive(matrix, target, m, n); 
        return optimal(matrix, target, m, n);
    }

    private static boolean optimal(int[][] mat, int t, int m, int n) {
        int r = 0;
        while(t > mat[r][n-1])
            r++;
        
        return binSearch(mat[r], 0, n-1, t);
    }

    private static boolean binSearch(int[] arr, int l, int r, int t) {
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (t == arr[mid]) {
                return true;
            } else if (t < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    // TC = O(M*N)
    // SC = O (1)
    private static boolean naive(int[][] matrix, int target, int m, int n) {
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (target == matrix[r][c]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}