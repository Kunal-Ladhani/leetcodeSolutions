class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // freq map to get freq of each element in O(1) time
        Map<Integer, Integer> freq = new HashMap<>();
        Set<Integer> unique = new HashSet<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            unique.add(n);
        }
        
        // min heap so that i can remove the minimum freq element
        // min freq element will be at top
        // store max freq k elements in queue
        Queue<Integer> pq = new PriorityQueue<>((p,q) -> freq.get(p) - freq.get(q));

        for (int n : unique) {
            if (pq.size() < k) {
                pq.offer(n);
            } else if (freq.get(n) > freq.get(pq.peek())) {
                pq.poll();
                pq.offer(n);
            }
        }

        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty() && i<k) {
            ans[i++] = pq.poll();
        }

        return ans;
    }
}