class Solution {
    public int[] twoSum(int[] arr, int x) {
        int[] ans = new int[2];
        int n = arr.length;
        Map<Integer,Integer> hm = new HashMap<>(n);
        hm.put(arr[0],0);
        
        for(int i=1; i<n; i++) {
            if(hm.containsKey(x-arr[i]) == true) {
                ans[0] = hm.get(x-arr[i]);
                ans[1] = i;
                break;
            } else {
                hm.put(arr[i],i);
            }
        }
        
        return ans;
    }
    
    private int[] nSquareSol(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;    
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}