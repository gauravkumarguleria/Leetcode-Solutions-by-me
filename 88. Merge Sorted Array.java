class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
       int p1 = m-1, p2 = n-1, p3 = m + n -1;

       while(p1>=0 && p2>=0){
        if(arr1[p1]> arr2[p2]){
            arr1[p3] = arr1[p1];
            p3--; p1--;
        }
        else{
            arr1[p3] = arr2[p2];
            p3--;p2--;
        }
       }
        while(p2>=0){
            arr1[p3] = arr2[p2];
            p3--; p2--;
        }
    }
}
