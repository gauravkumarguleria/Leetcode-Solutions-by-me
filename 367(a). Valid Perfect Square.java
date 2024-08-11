class Solution {
    public boolean isPerfectSquare(int num) {
        int count = countFactor(num);
        if(count%2 == 1) return true;
        return false; 
    }
    public int countFactor(int n){
        int count =0;
        for(long i =1 ; i*i<=n; i++ ){
            if(n%i != 0) continue;
            count++;
            if(i != n/i) count++;
        }
        return count;
    }
}
