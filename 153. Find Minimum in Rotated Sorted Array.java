class Solution {
    public int findMin(int[] nums) {
     int left = 0, right=nums.length-1;
     if(nums[left]<=nums[right]){
        return nums[0]; //no rotation
     }

     while(left<=right){
        int mid = left + (right-left)/2;
        if(nums[mid]>=nums[0]){
            //greater region
            left = mid + 1;
        }
       else right = mid - 1; //lesser region
     }  
     return nums[left];
    }
}
