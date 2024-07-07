class Solution {
    List<List<Integer>> result;

    public void printSubsets(int[] input, int idx, List<Integer>output){
        if(idx == input.length){
            result.add(new ArrayList<>(output)); //deep copy
            return;
        }

        //yes call
        output.add(input[idx]);
        printSubsets(input, idx+1, output);
        output.remove(output.size()-1);

        printSubsets(input, idx+1, output);
    }

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer>output = new ArrayList<>();
        printSubsets(nums,0,output);
        return result;
    }
}
