/*
class Solution {
    public boolean isPossible(int []piles, int hours, int speed){
        long sum=0;
        for(long bananas: piles){
            sum+=bananas/speed;
            if(bananas % speed != 0) sum++;

        }
        return (sum <= hours);
    }


    public int minEatingSpeed(int[] piles, int h) {
        long max = (int)1e9;

        for(int speed =1; speed<=max;speed++){
            if(isPossible(piles,h,speed)==true)
            return speed;
        }
        return -1;
    }
}
*/

class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int l = 1;
    int r = Arrays.stream(piles).max().getAsInt();

    while (l < r) {
      final int m = (l + r) / 2;
      if (eatHours(piles, m) <= h)
        r = m;
      else
        l = m + 1;
    }

    return l;
  }

  // Returns the hours to eat all the piles with speed m.
  private int eatHours(int[] piles, int m) {
    return Arrays.stream(piles).reduce(
        0, (subtotal, pile) -> subtotal + (pile - 1) / m + 1); // ceil(pile / m)
  }
}
