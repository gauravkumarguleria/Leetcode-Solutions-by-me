
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        //visited mark
        for(int idx=0; idx<n;idx++){
            int original = nums[idx]%(n+1);
            nums[original] += (n+1);
        }
        //frequency check
        for(int i=0; i< n;i++){
            int freq=nums[i]/(n+1);
            if(freq>1) return i;
        } 
        return n;
    }
}
