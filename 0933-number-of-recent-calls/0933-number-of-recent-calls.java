class RecentCounter {

    private static final int[] ARRAY = new int[10_000]; 
    // at max 10^4 requests will be there
    private int start;
    private int end;

    public RecentCounter() {
        start = 0;
        end = 0;
    }
    
    public int ping(int t) {
        while (start < end && (t > ARRAY[start] + 3000)) {
            start++;
        }
        ARRAY[end++] = t;
        return end - start;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */