class Solution {
    public int[] productExceptSelf(int[] nums) {
            int []prefix = getPrefix(nums);
            int []suffix = getSuffix(nums);
            int n = nums.length;
            int []ans=new int[n];
       
        for(int idx=0;idx<n;idx++){
            int left = (idx>0)?prefix[idx-1]:1;
            int right =(idx<n-1)?suffix[idx+1]:1;
            ans[idx] = left*right;
        }
        return ans;
    }

     public static int[] getPrefix(int[] nums){
        int []prefix = new int[nums.length];
        for(int idx=0;idx<nums.length;idx++)
            prefix[idx] =nums[idx]*((idx>0)?prefix[idx-1]:1);
        return prefix;
    }

     public static int[] getSuffix(int[] nums){
        int []suffix = new int[nums.length];
        for(int idx=nums.length-1;idx>=0; idx--)
            suffix[idx] =nums[idx]*((idx<nums.length-1)?suffix[idx+1]:1);
        return suffix;
    }
}
