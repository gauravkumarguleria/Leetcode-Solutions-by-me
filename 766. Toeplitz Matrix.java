class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        int m = mat.length, n= mat[0].length;
        for(int d=1-n;d<=m-1;d++){
            int row = (d<=0)?0:d;
            int col = (d<=0)?-d:0;
            int val = mat[row][col];

            while(row<m && col<n){
                if(mat[row][col] != val) return false;
                col++; row++;
            }
        }
        return true;
    }
}
