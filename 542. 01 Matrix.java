class Solution {
    public static class Pair{
        int r, c, dist;
        Pair(int r, int c, int dist){
            this.r =r;
            this.c =c;
            this.dist =dist;
        }
    } 
    int[] dx = {0, 0, -1,+1};
    int[] dy = {1, -1, 0, 0};
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new ArrayDeque<>();
        for(int r=0; r<mat.length; r++){
            for(int c=0; c<mat[0].length; c++){
                if(mat[r][c] == 1) mat[r][c] = -1;
                else q.add(new Pair(r, c, 0));
            }
        }

        while(q.size()>0){
            Pair p = q.remove();

            if(mat[p.r][p.c] == -1)
                mat[p.r][p.c] = p.dist;
            
            for(int d=0; d<4; d++){
                int nr = p.r + dx[d];
                int nc = p.c + dy[d];

                if(nr< 0 || nc<0 || nr>= mat.length || nc>= mat[0].length || mat[nr][nc] != -1)
                    continue;

                q.add(new Pair(nr, nc, p.dist+1));
            }
        }
        return mat;
    }
}
