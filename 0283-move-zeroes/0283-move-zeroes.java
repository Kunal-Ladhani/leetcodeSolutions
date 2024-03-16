class Solution {
    private void swap(int[] nums, int left, int right) {
        if(nums.length == 0 || nums == null) {
            return;
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    // TC = O(N) and O(1) SC
    public void moveZeroes(int[] nums) {
        if(nums == null) {
            return;
        }
        
        int n = nums.length;
        if(n == 1) {
            return;
        }
        
        int insertPos = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] != 0) {
                swap(nums, insertPos, i);
                insertPos++;
            }
        }
    }
    
    // O(N) TC and O(N) SC
    private void solver(int[] nums) {
        int n = nums.length;
        
        if(nums.length == 1) {
            return;
        }
        
        int[] temp = new int[n];
        int j = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] != 0) {
                temp[j++] = nums[i];
            }
        }
        int k=0;
        while(k < j) {
            nums[k] = temp[k++];
        }
        while(k < n) {
            nums[k++] = 0;
        }
    }
}