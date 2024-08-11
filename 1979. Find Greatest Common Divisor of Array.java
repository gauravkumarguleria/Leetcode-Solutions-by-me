class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;  
        return gcd(nums[0], nums[n-1]);    
    }
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
