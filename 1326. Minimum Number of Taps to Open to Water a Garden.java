class Solution {
    public int minTaps(int n, int[] ranges) {
        
        // how much range of garden can be covered by tap at i'th range.
        int dp[] = new int[n+1];

        //it is a starting point
        
        //initializing to maximum value
        Arrays.fill(dp, n+2);
        dp[0]=0;

        for(int i=0 ; i<=n ; i++) {
            // computing the left and right range the tap can cover
          int start = Math.max(i-ranges[i], 0);
          int end = Math.min(i+ranges[i], n);
           
          for(int j=start; j<= end; j++) {
            dp[j] = Math.min(dp[j], dp[start]+1);
            //if(dp[n] == 1) return 1;
           }

        }
        return dp[n] == n+2 ?-1: dp[n];
    }
}
