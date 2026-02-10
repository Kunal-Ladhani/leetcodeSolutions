class Solution {
    public int maxProduct(int[] nums) {
        return naive(nums);
    }

    // TC = O(NlogN)
    // SC = O(1)
    private static int naive(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        return (arr[n-1]-1) * (arr[n-2]-1);
    }


}