class Solution {
    private int findLargest(int[] arr) {
        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0; i<n; i++) {
            if(arr[i] > largest) {
                largest = Math.max(largest,arr[i]);
                idx = i;
            }
        }
        return idx;
    }
    
    public int dominantIndex(int[] arr) {
        int n = findLargest(arr);
        for(int i=0; i<arr.length; i++) {
            if(i != n && arr[n] < 2 * arr[i]) {
                return -1;
            }
        }
        return n;
    }
}