class Solution {
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n]; // O(N) SC aux space
        for(int i=0, j=0; i<n && j<2*n; i++, j+=2) {
            ans[j] = nums[i];
            ans[j+1] = nums[i+n];
        }
        return ans;
    }
}


// x1, x2, x3, ..., xn, y1, y2,  y3, ...,  yn
// 0,  1,  2,      ,n-1, n, n+1, n+2     , 2n-1