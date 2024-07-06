class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int row=0, col = mat[0].length-1;
        while(row<mat.length && col>=0){
            if(mat[row][col]==target){
                return true;
            }
            else if(mat[row][col]<target){
                row++;
            }
            else col--;
        }
        return false;
    }
}
