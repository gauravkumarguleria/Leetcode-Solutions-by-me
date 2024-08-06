class Solution {
    public int hammingWeight(int n) {
        int count =0;

        for( int bit=0; bit <32; bit++){
            if((n&(1<<bit))!= 0)
                count++;
        }
        return count;
    }
}
