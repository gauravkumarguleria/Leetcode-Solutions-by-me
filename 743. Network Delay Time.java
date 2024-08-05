class Solution {
    class Pair implements Comparable<Pair>{
        int node, weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Pair other){
            return this.weight - other.weight;
        }
    }
    class Graph{
        public int n;
        public ArrayList<Pair> [] adj;

        public Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i=0; i<n; i++){
                adj[i] = new ArrayList<>();
            }
        }
        public void addEdge(int src, int dest, int weight){
            adj[src].add(new Pair(dest, weight));
        }
    }
    public int networkDelayTime(int[][] times, int n, int source) {
        Graph g = new Graph(n+1);
        for(int[] edge: times)
            g.addEdge(edge[0], edge[1], edge[2]);
        
        int []vis = new int[n+1];
        Arrays.fill(vis, Integer.MAX_VALUE);

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(source,0));

        while(q.size()>0){
            Pair p = q.remove();
            if(vis[p.node]< p.weight) continue;
            vis[p.node] = p.weight;

            for(Pair nbr : g.adj[p.node]){
                if(vis[nbr.node] == Integer.MAX_VALUE)
                q.add(new Pair(nbr.node, p.weight + nbr.weight));

            }
        }
        int maximum = 0;
        for(int i=1;i<=n;i++){
            if(vis[i] == Integer.MAX_VALUE) return -1;
            maximum = Math.max(maximum, vis[i]);
        }
        return maximum;

    }
}
