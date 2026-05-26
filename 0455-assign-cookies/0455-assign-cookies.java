class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0)
            return 0;
        // return naive(g,s);
        return better(g, s);
    }

    // TC = (NlogN + MlogM)
    // SC = O(1)
    private static int better(int[] greed, int[] cookieSize) {
        Arrays.sort(greed);
        Arrays.sort(cookieSize);

        int ans = 0;
        int i = 0, n = cookieSize.length;
        int j = 0, m = greed.length;
        
        while (i < n && j < m) {
            if (cookieSize[i] >= greed[j]) {
                ans++;
                j++;
            }
            i++;
        }

        return ans;
    }


    // TC = O(N * M)
    // SC = O(1)
    private static int naive(int[] greed, int[] cookieSize) {
        int ans = 0;
        for (int i = 0; i < cookieSize.length; ++i) {
            
            if (cookieSize[i] != -1) {
                for (int j = 0; j < greed.length; ++j) {
                
                    if (greed[j] != -1 && cookieSize[i] >= greed[j]) {
                        ans++;
                        greed[j] = -1;
                        cookieSize[i] = -1;
                        break;
                    }

                }
            }
        }

        return ans;
    }

}