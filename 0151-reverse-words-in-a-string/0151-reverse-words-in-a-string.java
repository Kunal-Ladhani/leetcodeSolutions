class Solution {
    public String reverseWords(String s) {
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) != ' ')
                break;
            idx++; 
        }

        List<String> arr = new ArrayList<>();

        while (idx < s.length()) {
            StringBuilder word = new StringBuilder();
            
            while (idx < s.length() && s.charAt(idx) != ' ' && Character.isLetterOrDigit(s.charAt(idx))) {
                word.append(s.charAt(idx++));
            }
            
            if (!word.toString().trim().equals(""))
                arr.add(word.toString());

            idx++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i=arr.size()-1; i>=0; i--) {
            ans.append(arr.get(i));
            if (i > 0) {
                ans.append(' ');
            }
        }
        return ans.toString().trim();
    }
}