class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int[] prefixArray = new int[n];
        int[] suffixArray = new int[n];
        
        prefixArray[0] = 0;
        suffixArray[n-1] = 0;
        for(int i=1; i<n; i++) {
            prefixArray[i] = prefixArray[i-1] + arr[i-1];
            suffixArray[n-i-1] = suffixArray[n-i] + arr[n-i];
        }
        
        for(int i=0; i<n; i++) {
            if(prefixArray[i] == suffixArray[i]) {
                // this is pivot index
                return i;
            }
        }
        return -1;
        
    }
}