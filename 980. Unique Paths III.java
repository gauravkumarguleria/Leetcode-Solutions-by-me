/*class Solution {
    int startRow= -1, startCol=-1;
    int endRow=-1, endCol =-1;
    public int countPaths(int[][] mat, int row , int col, int freeCells){
        
        if(row<0 || col<0 || row == mat.length || col == mat[0].length){
            return 0;
        }

        if(mat[row][col] == -2 || mat[row][col] == -1){
            return 0;
        }

        if(row == endRow && col == endCol){
            if(freeCells == 0) return 1;
            else return 0;
        }

        mat[row][col] = -2;
        
        int paths = 0;
        paths += countPaths(mat, row-1, col, freeCells - 1);
        paths += countPaths(mat, row, col+1, freeCells - 1);

        paths += countPaths(mat, row, col-1, freeCells - 1);
         paths += countPaths(mat, row+1, col, freeCells - 1);
       
        mat[row][col] = 0;
        return paths;
        
    }

    public int uniquePathsIII(int[][] grid) {
        int freeCells = 1;

        for(int row = 0;row< grid.length; row++){
            for(int col = 9 ; col< grid[0].length; col++){
                if(grid[row][col] == 0){
                    freeCells++;}
                else if(grid[row][col] == 1){
                    startRow = row; startCol = col;}
                else if(grid[row][col] == 2){
                    endRow = row; endCol = col;}
            }
        }
         return countPaths(grid, startRow, startCol, freeCells);
    }
   
}
*/
class Solution {
    private boolean isValid(int[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0) return false;
        if (grid[row][col] == -1) return false;
        return true;
    }

    private int getUniquePaths(int[][] grid, int[][] diff, int row, int col, int step) {
        if (grid[row][col] == 2) {
            if (step == -1) return 1;
            return 0;
        }

        int count = 0;
        grid[row][col] = -1; // assigning to the current standing as if I mark next then I will never reach the goal(2) as it will be turned into (-1).
        for (int[] choice : diff) {
            int newRow = row + choice[0];
            int newCol = col + choice[1];
            if (isValid(grid, newRow, newCol)) {
                count += getUniquePaths(grid, diff, newRow, newCol, step - 1);
            }
        }
        grid[row][col] = 0;

        return count;
    }

    public int uniquePathsIII(int[][] grid) {
        int[][] diff = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        int sr = 0;
        int sc = 0;
        int steps = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 0) steps++;
            }
        }
        
        return getUniquePaths(grid, diff, sr, sc, steps);
    }
}
