class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, start = 0, mid = 0, end = 0, eqcount = 0, smcount = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            if(nums[i] < pivot)
                smcount++;
            else if(nums[i] == pivot)
                eqcount++;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] < pivot){
                arr[start] = nums[i];
                start++;
            }
            else if(nums[i] == pivot){
                arr[smcount + mid] = nums[i];
                mid++;
            }
            else{
                arr[smcount + eqcount + end] = nums[i];
                end++;
            }
        }
        return arr;
    }
}
