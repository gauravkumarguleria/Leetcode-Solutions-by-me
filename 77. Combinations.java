class Solution {
    List<List<Integer>> ways;
    
    public void printPaths(int n , int k , List<Integer> outputs){
        if(k==0){
            ways.add(new ArrayList<>(outputs));
            return;
        }
        if(n == 0|| k>n){
            return ;

        }
        //yes choice
        outputs.add(n);
        printPaths(n-1, k-1, outputs);
        outputs.remove(outputs.size()-1);

        printPaths(n-1, k , outputs);

    }

    public List<List<Integer>> combine(int n, int k) {
        ways = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        printPaths(n, k, output);
        return ways;
    }
}
