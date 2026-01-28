class Solution {
    public String longestCommonPrefix(String[] arr) {
        return optimal(arr);
    }

    private String optimal(String[] arr) {
        Arrays.sort(arr);   // O(NlogN) - no of string in inp array
        String first = arr[0];
        String last = arr[arr.length-1];

        int l = Math.min(first.length(), last.length());

        // O(M) - no of common chars
        StringBuilder sb = new StringBuilder();

        // O(M) - no of common chars
        for (int i=0; i<l; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            sb.append(first.charAt(i));
        }

        return sb.toString();
    }

    private String naive(String[] arr) {
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