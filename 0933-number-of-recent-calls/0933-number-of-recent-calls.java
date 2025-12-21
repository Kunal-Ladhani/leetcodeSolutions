class RecentCounter {

    private List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        int count = 0;
        for (int x : list) {
            if (x >= t-3000 && x <= t) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */