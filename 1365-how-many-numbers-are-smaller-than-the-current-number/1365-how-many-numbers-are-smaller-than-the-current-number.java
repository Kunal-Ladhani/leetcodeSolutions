class Solution {
    public int[] smallerNumbersThanCurrent(int[] arr) {
        int n = arr.length;
//         int[] temp = new int[n];
        
//         //TC = O(N), SC = O(N)
//         for(int i=0; i<n; i++) {
//             temp[i] = arr[i];
//         }
        int[] temp = arr.clone();
        
        Arrays.sort(temp);  // O(NlogN)
        
        //TC = O(N), SC = O(N)
        Map<Integer,Integer> smaller = new HashMap<>();
        for(int i=0; i<n; i++) {
            // if(smaller.get(temp[i]) == null) {
            //     smaller.put(temp[i],i);    
            // }
            smaller.putIfAbsent(temp[i],i);
        }

        // TC = O(N)        
        for(int i=0; i<n; i++) {
            temp[i] = smaller.get(arr[i]);
        }
         
        // TC = O(NlogN)
        return temp;
    }
    
    public int[] trivialSolution(int[] nums) {
        int n = nums.length, c = 0;
        int[] ans = new int[n];
        
        // TC = O(N^2) SC = O(1) excluding the space for answer
        for(int i=0; i<n; i++) {
            c = 0;
            for(int j=0; j<n; j++) {
                if(i != j && nums[j] < nums[i]) {
                    c++;
                }
            }
            ans[i] = c;
        }
        return ans;
    }
}