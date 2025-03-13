class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;

        // 1 element only
        // if even then we can pop and push even no of times and element will remain
        // if odd then last will be pop so -1
        if (n == 1)
            return k%2 == 0 ? nums[0] : -1;
        
        // size is > 1 but we have only 1 move and no element outside
        // so only pop the 0th element and 1st will be at top
        if (k == 1)
            return nums[1];
        
        // ans = maxElementTillNow
        int ans = 0;
        if (k > n) {
            // in this case we can waste time for n turns
            // then k%n turns will be left and we will know max ele so put it at top at last
            // we can always have max of array at top
            for (int i=0; i<n; i++)
                ans = Math.max(ans, nums[i]);
            return ans;
        } else if (k == n) {
            // till k-1 turns keep popping elements out and find max out of them
            for (int i=0; i<k-1; i++)
                ans = Math.max(ans, nums[i]);
            // put max at top
            return ans;
        } else {
            // k turns are less than n
            // till k-1 turns keep popping elements out and find max out of them
            for (int i=0; i<k-1; i++)
                ans = Math.max(ans, nums[i]);
            // now we can either pop (nums[k] will be at top) or push (ans will be at top)
            return Math.max(ans, nums[k]);
        }
    }
}