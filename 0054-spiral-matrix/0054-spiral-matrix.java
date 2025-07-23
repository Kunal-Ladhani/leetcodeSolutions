class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        int ctr = 0;
        int top = 0, bottom = rows-1, left = 0, right = cols-1;
        while (ctr < total) {
            
            // top side
            for (int c = left; ctr < total && c <= right; c++) {
                ans.add(matrix[top][c]);
                ctr++;
            }
            top++;

            // right side
            for (int r = top; ctr < total && r<=bottom; r++) {
                ans.add(matrix[r][right]);
                ctr++;
            }
            right--;

            // bottom side
            for (int c = right; ctr < total && c >= left; c--) {
                ans.add(matrix[bottom][c]);
                ctr++;
            }
            bottom--;

            // left side
            for (int r = bottom; ctr < total &&  r >= top; r--) {
                ans.add(matrix[r][left]);
                ctr++;
            }
            left++;
        }

        return ans;
    }
}