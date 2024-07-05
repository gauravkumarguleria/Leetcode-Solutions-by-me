/*
class Solution {
    public int search(int[] nums, int target) {
          int pivot = minFind(nums);
        if(target == 0) return binarySearch(nums, target, 0, nums.length-1);
        else if(target<nums[0]) return binarySearch(nums, target, pivot, nums.length-1);
        else return binarySearch(nums,target, 0, pivot-1);
       
    }


    public int binarySearch(int []nums, int target, int left, int right){
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if (nums[mid]<target){
                left = mid+1;
            }
            else right = mid - 1;
        }
        return -1;
    }



     public int minFind(int []nums){
        int left=0, right=nums.length-1;
        int mid = left + (right-left)/2;
        if(nums[left]<=nums[right])
            return 0;

        while(left<=right){   
        if (nums[mid]<=nums[0]){
                left = mid+1;
            }
            else right = mid - 1;
        }
        return nums[left];


        
    }
}*/

class Solution {
  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      final int m = (l + r) / 2;
      if (nums[m] == target)
        return m;
      if (nums[l] <= nums[m]) { // nums[l..m] are sorted.
        if (nums[l] <= target && target < nums[m])
          r = m - 1;
        else
          l = m + 1;
      } else { // nums[m..n - 1] are sorted.
        if (nums[m] < target && target <= nums[r])
          l = m + 1;
        else
          r = m - 1;
      }
    }

    return -1;
  }
}
