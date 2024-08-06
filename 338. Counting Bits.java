class Solution {
    public int[] countBits(int n) {
        int[] res= new int[n+1];
        for(int idx=1 ; idx<=n ; idx++){
           res[idx] = res[(idx>>1)] + (idx&1);
        }
        return res;
    }
}
