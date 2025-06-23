class Solution {
    private static void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b]= temp; 
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, k = n-1;

        while (j<=k) {
            if (nums[j] == 0) {
                swap (nums, j, i);
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                swap (nums, j, k);
                k--;
            }
            
        }
        
    }
}