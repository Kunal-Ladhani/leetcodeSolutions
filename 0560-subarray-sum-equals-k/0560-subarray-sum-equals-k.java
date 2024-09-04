class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length, sum = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            sum += arr[i];
        
            if(sum == k)
                count++;
            
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        
        return count;
    }
    
    public int naiveSolver(int[] arr, int k) {
        int n = arr.length, sum, count = 0;
        for (int i=0; i<n; i++) {
            sum = arr[i];
            if (sum == k)
                count++;
            for (int j=i+1; j<n; j++) {
                sum += arr[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
    
}