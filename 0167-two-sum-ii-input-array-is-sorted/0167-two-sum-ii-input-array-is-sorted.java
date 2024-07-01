class Solution {
    public int[] twoSum(int[] arr, int t) {
        int[] ans = new int[2];
        int n = arr.length;
        
        int s = 0, e = n-1;
        while(s < e) {
            if(arr[s] + arr[e] == t) {
                ans[0] = s+1;
                ans[1] = e+1;
                return ans;
            } else if(arr[s] + arr[e] > t) {
                while(e >= 1 && arr[e-1] == arr[e]) {
                    e--;
                }
                e--;
            } else {
                while(s < n && arr[s] == arr[s+1]) {
                    s++;
                }
                s++;
            }
        }
        return ans;
    }
}