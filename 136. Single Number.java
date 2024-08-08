class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int val : nums)
            xor ^= val;
        return xor;
    }
}
