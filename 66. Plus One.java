class Solution {
  public int[] plusOne(int[] digits) {
    for (int idx = digits.length - 1; idx >= 0; idx--) {
      if (digits[idx] == 9) {
        digits[idx] = 0;
      }
      else{
        digits[idx]++;
        return digits;
      }
      
    }

    int[] ans = new int[digits.length + 1];
    ans[0] = 1;
    return ans;
  }
}
