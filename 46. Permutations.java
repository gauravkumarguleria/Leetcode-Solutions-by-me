class Solution {
    List<List<Integer>> ways;

    public void printPaths(int[]nums, List<Integer> output){
        if(output.size()== nums.length){
            ways.add(new ArrayList<>(output));
            return;
        }
        for(int idx = 0;idx< nums.length; idx++){
            if(output.contains(nums[idx])==true) continue;
            output.add(nums[idx]);
            printPaths(nums, output);
            output.remove(output.size()-1);
        }
    }



    public List<List<Integer>> permute(int[] nums) {
        ways = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        printPaths(nums, output);
        return ways;
    }
}
