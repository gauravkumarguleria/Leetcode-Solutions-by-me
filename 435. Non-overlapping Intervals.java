class Solution {
    int inf =Integer.MAX_VALUE;
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(t,o)->{
            if(t[0]<o[0]) return +1;
            else if(t[0]>o[0]) return -1;
            else return 0;
        });
        
        int removals = 0;
        int[] next = {inf, inf};
        for(int []curr: intervals){
            if(curr[1] <= next[0]) next =curr;
            else removals++;
        }
        return removals;
    }
}
