class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (t,o)->{
                double d1 = Math.sqrt(t[0]*t[0] + t[1]*t[1]);
                double d2 = Math.sqrt(o[0]*o[0] + o[1]*o[1]);

                if(d1<d2) return +1;
                else if(d1>d2) return -1;
                else return 0;
            });
        for(int[] p: points){
            if(pq.size()<k) pq.add(p);
            else{
                pq.add(p);
                pq.remove();
            }
        }
        int[][] res = new int[k][2];
        for(int idx=0;idx<k;idx++){
            res[idx] = pq.remove();
        }
        return res;
    }
}
