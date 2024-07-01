class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];

        for(int row=0;row<res.length;row++){
            for(int col =0; col<res[0].length; col++){
               res[row][col]= matrix[col][row];
              }
        }
        return res;
    }
}
