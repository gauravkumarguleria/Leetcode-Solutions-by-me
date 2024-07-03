class Solution {
    public int search(int[] nums, int target) {
       /* int low = 0;
        int high = nums.length -1;
        while(low<high){
          int  mid = low + (high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return nums[low]==target?low:-1;
        */

        int left=0, right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]==target)
            return mid;
            else if (nums[mid]<target )
                left = mid +1;
            else right = mid -1;
        }
        return -1;
    }
}
