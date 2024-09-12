class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for(int idx = 0; idx<n; idx++){
            int original = nums[idx]%(n+1);
            nums[original - 1] += (n+1);
        }

        int repeating = 0, missing = 0;

        for(int idx = 0; idx <n; idx++){
            int freq = nums[idx]/(n+1);
            
            if(freq==0) missing = idx+1;
            if(freq==2) repeating = idx+1;
        }
    
        
        return new int[]{repeating, missing};
            }
}
