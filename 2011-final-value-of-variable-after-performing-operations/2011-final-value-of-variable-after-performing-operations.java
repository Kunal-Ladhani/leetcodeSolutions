class Solution {
    public int finalValueAfterOperations(String[] arr) {
    int n = arr.length, ans = 0;
    for(int i=0; i<n; i++) {
        if(arr[i].charAt(1) == '+') {
            ans++;
        } else {
            ans--;
        }
    }
    return ans;    
    }
}