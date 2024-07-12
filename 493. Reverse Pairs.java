class Solution {
    int count = 0;
    void countPairs(int [] arr1, int []arr2){
        int n1= arr1.length, n2 = arr2.length;
        int p1=0, p2=0;
        while(p1<n1 &&p2<n2){
            if(arr1[p1] <= 2l*arr2[p2]){
                p1++;
            }else{
                count += (n1 - p1);
                p2++;
            }
        }
    }
    
    int[]merge(int arr1[], int []arr2){
        int n1 = arr1.length, n2 = arr2.length;
        int []arr3 = new int[n1+n2];
        int p1=0, p2=0, p3=0;

        countPairs(arr1, arr2);
        
        while(p1<n1 && p2<n2){
            if(arr1[p1]<=arr2[p2]){
                arr3[p3] = arr1[p1];
                p3++;p1++;
            }else{
                arr3[p3] = arr2[p2];
                p3++; p2++;
            }
        }
        while(p1<n1){
            arr3[p3] = arr1[p1];
            p3++; p1++;
        }
        while(p2<n2){
            arr3[p3] = arr2[p2];
            p3++;p2++;
        }
        return arr3;
    }
    int[]mergeSort(int[] nums, int left, int right){
        if(left == right)
            return new int []{nums[left]};
        
        int mid = left + (right - left)/2;
        int []larr = mergeSort(nums, left, mid);
        int []rarr = mergeSort(nums, mid+1, right);
        return merge(larr,rarr);
        
    }
    
    
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return count;
    }
}
