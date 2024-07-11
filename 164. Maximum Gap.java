class Solution {
    public int maximumGap(int[] nums) {
        //RADIX SORT
        for(int place=1; place<=(int)1e8;place*=10){
            nums = countSort(nums, place);
        }

        int gap =0;
        for(int idx=1; idx<nums.length;idx++){
            if(nums[idx] - nums[idx-1] > gap){
                gap = nums[idx] - nums[idx-1];
            }
        }
        return gap;
    }

    public int[] countSort(int[]nums, int place){
        int[] freq = new int[10];

        //pass 1
        for(int ele: nums){
            int digit = (ele %(10*place))/place;
            freq[digit]++;
        }

        //place 2
        for(int idx=1; idx<freq.length; idx++){
            freq[idx] +=freq[idx - 1];
        }

        //place 3
        int[] res = new int[nums.length];
        for(int i= nums.length-1; i>=0; i--){
            int ele = nums[i];
            int digit = (ele %(10*place))/place;
            freq[digit]--;
            int last = freq[digit];
            res[last] = ele;
        }
        return res;
    }
}
