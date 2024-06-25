class Solution {
    public int pivotIndex(int[] nums) {
        int []prefix = getPrefix(nums);
        int []suffix = getSuffix(nums);
for(int idx=0;idx<nums.length;idx++){
    if(prefix[idx] == suffix[idx])
        return idx;
}

      return -1;

    }
 
    public static int[] getPrefix(int[] nums){
        int []prefix = new int[nums.length];
        for(int idx=0;idx<nums.length;idx++)
            prefix[idx] =nums[idx]+((idx>0)?prefix[idx-1]:1);
        return prefix;
    }

     public static int[] getSuffix(int[] nums){
        int []suffix = new int[nums.length];
        for(int idx=nums.length-1;idx>=0; idx--)
            suffix[idx] =nums[idx]+((idx<nums.length-1)?suffix[idx+1]:1);
        return suffix;
    }
}
