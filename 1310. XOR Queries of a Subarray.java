class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length , q = queries.length;

        int[] pref = new int[n+1];
        for(int i = 1; i<=n ; i++){
            pref[i] = pref[i-1]^arr[i-1];
        }

        int[] res = new int[q];
        for(int i =0; i<q; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = pref[r+1] ^ pref[l];
        }
        return res;
    }
}
