class Solution {
    public String convertToBase7(int N) {
        long res = 0, power=1;

        while(N != 0){
            int remainder = N %7;
            res = res + power*remainder;
            N/=7;
            power*=10;
        }
        return String.valueOf(res);
    }
}
