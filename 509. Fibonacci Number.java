class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int a=0,b=1,c=1;

        for(int idx=2; idx<=n;idx++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
