class Solution {
  public int reverse(int x) {
  int  ans=0;
   while(x!=0){
    int digit = x%10;
    int newans = ans*10+digit;
    if(newans/10 != ans) return 0;
    ans =newans;
    x/=10;
   }
   return ans;
  }
}
