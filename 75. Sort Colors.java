class Solution {
    public void sortColors(int[] nums) {
      /*
        int zeros = 0, ones = 0, twos =0;
        //First Pass
        for(int val: nums){
            if(val == 0) zeros++;
            else if(val == 1) ones++;
            else twos++;
        }
        //Second ones
        for(int idx = 0; idx<nums.length; idx++){
            if(idx<zeros) nums[idx] =0;
            else if(idx < zeros + ones) nums[idx] =1;
            else nums[idx] =2;
        }
     
*/
        //One pass
        int i=0, j=0, k = nums.length-1;
        while(j<=k){
            if(nums[j]==0){
                swap(nums,i,j);
                i++; j++;
            }
            else if(nums[j]==1){
                j++;
            }
            else{
                swap(nums,j,k);
                k--;
            }
        }
}
public static  void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
}
