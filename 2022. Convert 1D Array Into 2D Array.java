class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
      /*  if(m*n != original.length) return new int[0][0];
        
        int [][]res = new int[m][n];

        int idx = 0;
        for(int row = 0 ;row< m; row++){
            for(int col = 0; col<n;col++){
                res[row][col] = original[idx++];
            }
        }
            return res;
            */

        if(m*n != original.length) return new int[0][0];

        int [][] res = new int[m][n];
        for(int idx=0; idx<original.length; idx++){
            int row = idx/n;
            int col = idx%n;
            res[row][col] = original[idx];
        }

        return res;
    }
}
