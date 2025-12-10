class Solution {
    public int romanToInt(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int ans = 0;
        for(int i = 0; i < str.length()-1; ++i) {
            int f = map.get(str.charAt(i));
            int s = map.get(str.charAt(i+1));
            if (f < s)
                ans -= f;
            else
                ans += f;
        }
        ans += map.get(str.charAt(str.length()-1));
        return ans;
    }
}