class Solution {
    // O(N)
    public int[] smallerNumbersThanCurrent(int[] arr) {
        int n = arr.length;
        int[] freq = new int[101];
        int[] ans = new int[n];
        // 0 <= arr[i] <= 100  total possible vals = 0 + 1....100 = 101
        
        // indx = // 0 1 2 3 4 5 6 7 8 9 ...
        // freq = // 0 1 2 1 0 0 0 0 1 0 ... 
        // +1   = // 0 1 3 4 0 0 0 0 5 0 ...
        // answ = // x 0 2 3 x x x x 4 x ...
                
        for(int i=0; i<n; i++) {
            freq[arr[i]] += 1;        
        }
        for(int i=1; i<=100; i++) {
            freq[i] += freq[i-1];
        }
        for(int i=0; i<n; i++) {
            int pos = arr[i];
            ans[i] = (pos == 0) ? 0 : freq[pos-1];
        }
        return ans;
    }
    
    // O(NlogN)
    public int[] betterSol(int[] arr) {
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
         
        // TC = O(NlogN) SC = O(N) for HM
        return temp;
    }
    
    // O(N^2)
    public int[] naiveSol(int[] nums) {
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