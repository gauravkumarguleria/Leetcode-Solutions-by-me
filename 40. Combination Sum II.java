class Solution {

    List<List<Integer>> ways;

    public void printWays(int[] coins, int idx, int target, List<Integer> output){
        if(target<0) return;  
        if(idx==coins.length){
            if(target == 0)
                ways.add(new ArrayList<>(output));
                return;
        }

        //yes
        output.add(coins[idx]);
        printWays(coins, idx+1, target - coins[idx], output);
        output.remove(output.size() -1);

        //no
       
        if(output.size()>0 && output.get(output.size()-1)==coins[idx])
        return;
         printWays(coins, idx+1, target, output);
    }

    public List<List<Integer>> combinationSum2(int[] coins, int target) {
        Arrays.sort(coins);
        ways = new ArrayList<>();
        printWays(coins, 0, target, new ArrayList<>());
        return ways;
    }
}
