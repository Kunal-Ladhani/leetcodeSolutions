class Solution {
    public String longestCommonPrefix(String[] arr) {
        int len = Integer.MAX_VALUE;
        for (String s : arr) {
            len = Math.min(len, s.length());
        }

        StringBuilder sb = new StringBuilder();
        boolean stopCheck = false;
        for (int i=0; i<len && stopCheck == false; i++) {
            char matcher = arr[0].charAt(i);
            for (int j = 1; j<arr.length; j++) {
                if(matcher != arr[j].charAt(i)) {
                    stopCheck = true;
                    break;
                }
            }
            if (stopCheck == false)
                sb.append(matcher);
        }

        return sb.toString();    
    }
}