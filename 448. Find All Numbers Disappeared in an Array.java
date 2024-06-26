class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        //visited mark
        for(int idx=0; idx<n;idx++){
            int original = nums[idx]%(n+1);
            nums[original-1] += (n+1);
        }

        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0 ; i<n;i++){
            int freq = nums[i]/(n+1);
            if(freq==0) answer.add(i + 1);
        }
       return answer;
    }
}
