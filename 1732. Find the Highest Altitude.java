class Solution {
    public int largestAltitude(int[] gain) {
        int ans =0, altitude =0;
        for(int alt: gain){
            altitude+=alt;
            ans= Math.max(ans,altitude);
            //if(ans>altitude) ans = altitude;
        }
       return ans;
    }
}
