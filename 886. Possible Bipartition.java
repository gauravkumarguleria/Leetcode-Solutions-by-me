class Solution {
    class Graph{
        public int n;
        public  ArrayList<Integer>[] adj;

        public Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i=0; i<n;i++)
                adj[i] = new ArrayList<>();
        }
        public void addEdge(int src, int dest){
            adj[src].add(dest);
            adj[dest].add(src);
        }
    }
   static class Pair{
        int src, color;
        Pair(int src, int color){
            this.src = src;
            this.color=color;

        }
    }
    public boolean bfs(int src, int[] vis){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,0));
        while(q.size()>0){
            Pair p = q.remove();
            if(vis[p.src] != -1 && vis[p.src] == p.color)
            continue;
            if(vis[p.src] != -1 && vis[p.src] != p.color)
            return false;

            vis[p.src] = p.color;
            for(Integer nbr: adj[p.src]){
                q.add(new Pair(nbr, 1-p.color));
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Graph g = new Graph(n);
        for(int[] edge : dislikes){
            g.addEdge(edge[0]-1, edge[1] -1);
        }

        int [] vis= new int[n];
        Arrays.fill(vis, -1);
        for(int i=0;i<n;i++){
            if(vis[i] != -1) continue;
            if(g.bfs(i,vis) == false) return false;
        }
        return true;
    }
}
