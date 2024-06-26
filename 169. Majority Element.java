class Solution {
    public int majorityElement(int[] nums) {
        int majority =0; int lead = 0;
        for(int val: nums){
            if(val==majority){
                lead++;
            }
            else if( lead == 0 ){
                majority = val;
                lead=1;
            }
            else{
                lead--;
            }
            
        }
        return majority;
    }
}
