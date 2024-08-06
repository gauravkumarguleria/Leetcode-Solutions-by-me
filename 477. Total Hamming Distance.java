class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;

        for(int a: nums){
            for(int b: nums){
                sum += Integer.bitCount(a^b);
            }
        }
        return sum/2;
    }
}
