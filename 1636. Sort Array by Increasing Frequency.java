class Solution {
    public int[] frequencySort(int[] nums) {
        int min = -100, max = 100;
        int[] freq = new int[max-min+1];

        for(int ele : nums){
            freq[ele-min]++;
        }

        ArrayList<Integer> [] buckets = new ArrayList[nums.length + 1];

        for(int bucket=0; bucket<buckets.length;bucket++){
            buckets[bucket] = new ArrayList<>();
        }

        for(int ele = min;ele<=max; ele++){
            int count = freq[ele - min];
            if(count == 0) continue;
            buckets[count].add(ele);
        }

        int idx =0;
        for(int bucket = 1; bucket<buckets.length;bucket++){
            Collections.reverse(buckets[bucket]);
            for(int ele: buckets[bucket]){
                for(int f =0; f< bucket; f++){
                    nums[idx++] = ele;
                }
            }
        }

return nums;
    }
}
