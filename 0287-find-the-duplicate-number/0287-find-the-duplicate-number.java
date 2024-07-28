class Solution {
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        if(n == 1) {
            return arr[0];
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(hs.contains(arr[i])) {
                return arr[i];
            }
            hs.add(arr[i]);
        }
        return -1;
    }
}