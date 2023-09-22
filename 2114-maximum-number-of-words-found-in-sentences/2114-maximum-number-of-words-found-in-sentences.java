class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0, n = sentences.length;
        for(int i=0; i<n; i++) {
            String str = sentences[i].trim();
            String[] words = str.split(" ");
            ans = Math.max(ans,words.length);
            
        }
        return ans;
    }
}