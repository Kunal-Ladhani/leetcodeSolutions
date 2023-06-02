class Solution {
    private void swap(int a, int b) {
        int temp = b;
        b = a;
        a = temp;
    }
    
    private void swapper(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
    
    // cannot use extra space -> SC = O(1)
    public int removeElement(int[] nums, int val) {
        int n = nums.length, i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] != val) {
                // swap(nums[i],nums[j]);  // does not work
                swapper(nums,i,j);   // this will work 
                i++;
            }
        }
        return i;
    }
}