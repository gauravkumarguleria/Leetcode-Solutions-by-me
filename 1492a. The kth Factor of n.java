class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for(long i = 1; i*i <= n; i++){
            if(n%i != 0) continue;

            left.add((int)i);
            if(i != n/i)
                right.add((int)(n/i));
        }
        Collections.reverse(right);
        left.addAll(right);

        if(k> left.size()) return -1;
        return left.get(k-1);
    }
}
