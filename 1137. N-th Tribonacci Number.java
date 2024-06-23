class Solution {
  public int tribonacci(int n) {
    if(n == 0) return 0;
    if(n ==1 || n==2) return 1;
    int a=0,b=1,c=1,d=1;
    for(int idx=3; idx<=n ; idx++){
        d= a+b+c;
        a =b;
        b = c;
        c = d;
    }
return c;
  }
}
