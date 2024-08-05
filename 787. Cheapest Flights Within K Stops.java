class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int inf = (int)1e9;
        int[] dist = new int[n];
        Arrays.fill(dist, inf);
        dist[src] = 0;

        for(int relax = 0; relax<=k; relax++){
            int[] copy = new int[n];
            for(int i =0; i <n ; i++)
                copy[i] = dist[i];

            for(int[] edge : flights){
                int out = edge[0];
                int in = edge[1];
                int weight = edge[2];

                if(dist[out] == inf) continue;
                copy[in] = Math.min(copy[in], dist[out] + weight);
            } 
            dist = copy;

        }
        if(dist[dst] == inf) return -1;
        return dist[dst];
    }
}
