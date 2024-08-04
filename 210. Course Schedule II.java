class Solution {
    static class  Graph{
        public int n;
        public ArrayList<Integer>[] adj;

        public Graph(int n){
            this.n=n;
            adj = new ArrayList[n];
            for(int i=0; i<n; i++)
                adj[i] = new ArrayList<>();
        }
        public void addEdge(int src, int dest){
            adj[src].add(dest);
        }
    }
    public int[] findOrder(int V, int[][] prerequisites) {
         Graph g = new Graph(V);
        for(int [] edge : prerequisites)
            g.addEdge(edge[1], edge[0]);
        
        int [] incoming = new int[V];
      
            for(int[] node: prerequisites)
                incoming[node[0]]++;
        
        int topo[] = new int[V];
        int pop = 0, push =0;
        
        for(int i=0; i<V; i++){
            if(incoming[i] ==0)
                topo[push++] = i;
        }
        
        while(pop<push && push<V){
            int src = topo[pop++];
            
            for(int nbr: g.adj[src]){
                incoming[nbr]--;
                if(incoming[nbr]==0)
                    topo[push++] = nbr;
            }
        }
        if(push == V) return topo;
        else return new int[0];
    }
}
