class Solution {
    public int maxDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int left=0, right = stalls[n-1] - stalls[0];
        while(left<=right){
            int mid = left + (right-left)/2;

            if(isPossible(stalls,cows,mid) == true){
                left = mid +1;
            }
            else{
                right = mid-1;
            }
        }
        return right;
    }


    public boolean isPossible(int[]stalls , int cows, int dist ){
        int placed = 1;
        int last = stalls[0];
        for(int curr: stalls){
         if(curr - last >= dist) {  
            placed++;
            last = curr;
        }
        }
return (placed>=cows);
    }
}
