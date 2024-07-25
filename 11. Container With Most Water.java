class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while(i<j){
            int left = height[i];
            int right = height[j];

            int max = Math.min(left, right)*(j-i);
            maxArea = Math.max(max,maxArea);

            if(left<right){
                i++;
            }
            else{
                j--;
            }
        }
        return maxArea;
    }
}
