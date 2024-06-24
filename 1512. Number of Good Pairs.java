class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0 ;
        for(int idx=0;idx<nums.length;idx++){
            for(int j = idx+1; j <nums.length; j++){
                if(nums[idx]==nums[j]){
                    count++;
                }
            }
        }return count;
    }
}
