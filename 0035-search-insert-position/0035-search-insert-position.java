class Solution {
    // me or next greater than me
    
    // 1 3 6 7 9
    // t = 4
    // ans = 2
    
    // l=0, h=4, mid=2 nums[mid] = 6 > target
    // ans = 2, l = 0, h = 1, mid = 0
    
    public int searchInsert(int[] nums, int target) {        
        int N = nums.length;
        int l = 0, h = N-1, mid;
        
        if(target < nums[l])
            return l;
        else if(target > nums[h])
            return h+1;
        
        while(l <= h) {
            mid = l + (h-l)/2;
            if(nums[mid] == target) {
                return mid;   
            }
            else if(nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}