/*
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
       Arrays.sort(heaters); //closest heater queries

       int minRadius = 0;
       for(int house:houses){
        int radius = findClosest(heaters,house);
        minRadius = Math.max(minRadius,radius);
       }
return minRadius;

    }
    public int findClosest(int[] heaters, int house){
        int floor = floorInArray(heaters, house);
        int ceil = floor + 1;

        int floorDist= (floor == -1 )?Integer.MAX_VALUE:(house - heaters[floor]);
        int ceilDist= (floor == heaters.length )?Integer.MAX_VALUE:( heaters[ceil] - house);

        return Math.min(floorDist,ceilDist);
    }




     public int floorInArray(int []arr,int target){
            int left=0, right=arr.length-1;
            while(left<=right){
            int    mid= left + (right-left)/2;
                if(arr[mid]==target){
                    right = mid-1;
                }
                else if(arr[mid]<target){
                    left=mid+1;
                    
                }
                else{
                    right = mid -1;
                }
            }return right;
        }
}
*/
class Solution {
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int ans = 0;
    int i = 0; // heaters' index (currently used)

    for (final int house : houses) {
      while (i + 1 < heaters.length && house - heaters[i] > heaters[i + 1] - house)
        ++i; // The next heater is better.
      ans = Math.max(ans, Math.abs(heaters[i] - house));
    }

    return ans;
  }
}
