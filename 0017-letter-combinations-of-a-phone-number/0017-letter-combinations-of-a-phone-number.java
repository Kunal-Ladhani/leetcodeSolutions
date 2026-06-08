class Solution {

    public List<String> letterCombinations(String digits) {
        // Map<Integer, String> mapping = new HashMap<>();
        // mapping.put(2, "abc");
        // mapping.put(3, "def");
        // mapping.put(4, "ghi");
        // mapping.put(5, "jkl");
        // mapping.put(6, "mno");
        // mapping.put(7, "pqrs");
        // mapping.put(8, "tuv");
        // mapping.put(9, "wxyz");

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        recUtil(digits, ans, 0, new StringBuilder(), mapping);
        return ans;
    }

    private static void recUtil(String digits, List<String> ans, int idx, StringBuilder sb, String[] mapping) {
        if (digits.length() == idx) {
            ans.add(sb.toString());
            return;
        }

        String candidates = mapping[digits.charAt(idx)-'0'];
        for (int i=0; i<candidates.length(); ++i) {
            sb.append(candidates.charAt(i));
            recUtil(digits, ans, idx+1, sb, mapping);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    // private static void recUtil(String digits, List<String> ans, int idx, StringBuilder sb, Map<Integer, String> mapping) {
    //     if (digits.length() == sb.length()) {
    //         ans.add(sb.toString());
    //         return;
    //     }

    //     String candidates = mapping.get(digits.charAt(idx)-'0');
    //     for (int i=0; i<candidates.length(); ++i) {
    //         sb.append(candidates.charAt(i));
    //         recUtil(digits, ans, idx+1, sb, mapping);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    // }

}


