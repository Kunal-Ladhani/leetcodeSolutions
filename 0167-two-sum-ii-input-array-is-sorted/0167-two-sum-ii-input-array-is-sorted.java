class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return twoSumSorted(numbers,target);
    }
    
    // TC = O(N), SC = O(N)
    public int[] twoSumUnsorted(int[] arr, int k) {
        int[] ans = new int[2];
        int n = arr.length;
        if (n <= 1) return ans;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(map.containsKey(k - arr[i])) {
                ans[0] = map.get(k - arr[i]) + 1;
                ans[1] = i+1;
                return ans;
            }
            map.put(arr[i],i);
        }
        return ans;
    }
    
    // TC = O(N), SC = O(1)
    public int[] twoSumSorted(int[] arr, int k) {
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