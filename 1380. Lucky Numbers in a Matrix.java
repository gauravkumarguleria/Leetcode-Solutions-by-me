class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        for(int row =0;row< mat.length;row++){
            int min =0;
            for(int col=0; col<mat[0].length;col++){
                if(mat[row][col]<mat[row][min]){
                    min=col;
                }
            }

            int max=0;
            for(int r=0;r<mat.length;r++){
                if(mat[r][min]>max){
                    max=mat[r][min];
                }
            }
            if(max==mat[row][min]){
                List<Integer> res= new ArrayList<>();
                res.add(max);
                return res;
            }
        }
    return new ArrayList<>();
    }

}
