class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        int n = arr.length;

        if (n <= 1)
            return arr;

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<int[]> temp = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            temp.add(new int[]{entry.getValue(), entry.getKey()});
        }

        Collections.sort(temp, (a,b) -> b[0] - a[0]);

        for(int i=0; i<k; i++) {
            ans[i] = temp.get(i)[1];
        }

        return ans;

    }
}