class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;

        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;

        int count = 0;
        for(long i = 2l; i< n; i++){
            if(prime[(int)i] == false) continue;
            count++;
            for(long j = i*i ; j<n ; j+=i){
                prime[(int)j] = false;
             }
        }
        return count;
    }
}
