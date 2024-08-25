class Solution {
    public int[] distributeCandies(int candies, int people) {
        int[] ans = new int[people];
        int candy =1;
        int idx = 0;

        while(candy<=candies){
            if(idx == people) idx = 0;
           
            ans[idx] += candy;
            candies -= candy;
            candy+=1; 
            idx++;
        }

        if(candies>0){
            if(idx == people) idx = 0;
            ans[idx] += candies;
        }

        return ans;
    }
}
