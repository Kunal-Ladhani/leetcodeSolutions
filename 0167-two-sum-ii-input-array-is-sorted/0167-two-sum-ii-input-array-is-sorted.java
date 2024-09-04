class Solution {
    public int[] twoSum(int[] arr, int k) {
        int[] ans = new int[2];
        int n = arr.length;
        if (n <= 1) return ans;
        
        int l = 0, h = n-1;
        while(l < h) {
            if (arr[l] + arr[h] == k) {
                ans[0] = l+1;
                ans[1] = h+1;
                return ans;
            } else if (arr[l] + arr[h] > k) {
                h--;
            } else {
                l++;
            }
        }
        return ans;
    }
}