class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<n1; i++) {
            hm.put(nums1[i],1);
        }
        
        for(int i=0; i<n2; i++) {
            if(hm.containsKey(nums2[i]) && hm.get(nums2[i]) == 1) {
                ans.add(nums2[i]);
                hm.put(nums2[i],0);
            }
        }
        
        return ans.stream().mapToInt(i->i).toArray();
    }
    
    public int[] intersection0(int[] nums1, int[] nums2) {
        Set<Integer> hs1 = new HashSet<>();
        Set<Integer> hs2 = new HashSet<>();
        
        for(int i=0 ;i<nums1.length; i++) {
            hs1.add(nums1[i]);
        }
        
        for(int i=0 ;i<nums2.length; i++) {
            hs2.add(nums2[i]);
        }
        
        List<Integer> temp = new ArrayList<>();
        for(Integer i : hs1) {
            if(hs2.contains(i)) {
                temp.add(i);
            }
        }    

        int[] ans = new int[temp.size()];
        for(int i=0; i<ans.length; i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}