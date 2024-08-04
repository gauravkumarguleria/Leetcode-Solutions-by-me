class Solution {
    public boolean dfs(int src, int color, int[][] adj, int[] vis){
        if(vis[src] != -1) {
            if(vis[src] == color) return true;
            else return false;
        }

        vis[src] = color;
        for(int nbr: adj[src]){
            if(dfs(nbr, 1-color, adj, vis) == false)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] adj) {
        int n = adj.length;
        int [] vis = new int[n];
        Arrays.fill(vis,-1);


        for(int i=1; i<n ; i++){
            if(vis[i] != -1) continue;
            if(dfs(i,0,adj,vis) == false) return false;
        }
        return true;
     }
}
