class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;

        //visited mark
        for(int idx=0; idx<n;idx++){
            int original = nums[idx]%(n+1);
            nums[original-1] += (n+1);
        }

        //frequency check
        List<Integer> duplicate = new ArrayList<>();

        for(int i=0; i< n;i++){
            int freq=nums[i]/(n+1);
            if(freq>1) duplicate.add(i+1);
        } 
        return duplicate;
  }
}
