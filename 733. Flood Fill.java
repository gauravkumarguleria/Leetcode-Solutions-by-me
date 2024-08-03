class Solution {
    public void dfs(int r, int c, int[][]image, int oldcolor, int newcolor){
        if(r<0||c<0||r>=image.length||c>=image[0].length)
            return;
        
        if(image[r][c] != oldcolor) return;
        image[r][c] = newcolor;
        
        dfs(r-1,c,image, oldcolor,newcolor);
        dfs(r+1,c,image, oldcolor,newcolor);
        dfs(r,c-1,image, oldcolor,newcolor);
        dfs(r,c+1,image, oldcolor,newcolor);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int oldcolor = image[sr][sc];
        if(oldcolor != newcolor)
            dfs(sr, sc, image, oldcolor, newcolor);
        return image;

    }
}
