class Solution {

    static class Point {
        double dist;
        int x;
        int y;

        Point(double dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    private static double getDistance(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Queue<Point> pq = new PriorityQueue<>((p,q) -> Double.compare(q.dist,p.dist));  // MAX HEAP

        for (int i=0; i<n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double dist = getDistance(x,y);

            Point p = new Point(dist, x, y);

            if (pq.size() < k) {
                pq.offer(p);
            } else if (p.dist < pq.peek().dist) {   // remove fathest point when closer one arrives
                pq.poll();
                pq.offer(p);
            }
        }

        int[][] ans = new int[k][2];
        int cntr = 0;
        while (!pq.isEmpty() && cntr < k) {
            Point p = pq.poll();
            ans[cntr][0] = p.x;
            ans[cntr][1] = p.y;
            cntr++;
        }

        return ans;
    }
}