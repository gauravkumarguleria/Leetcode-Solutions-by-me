/*
class Solution {
        public int[] rightNSE(int []arr){
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int [] res= new int[n];

        for(int idx= n-1; idx>-0;idx--){
            while(stk.size()>0 && arr[stk.peek()]>=arr[idx]){
                stk.pop();
            }
            res[idx] = (stk.size()>0)? stk.peek():n;
            stk.push(idx);
        }
        return res;
    }
    
    public int[] leftNSE(int []arr){
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int [] res= new int[n];

        for(int idx=0; idx<n;idx++){
            while(stk.size()>0 && arr[stk.peek()]>=arr[idx]){
                stk.pop();
            }
            res[idx] = (stk.size()>0)? stk.peek():-1;
            stk.push(idx);
        }
        return res;
    }
    
    
    public int sumSubarrayMins(int[] arr) {
         int [] left = leftNSE(arr);
        int [] right = rightNSE(arr);
        long ans=0;
        for(int idx=0;idx<arr.length;idx++){
            long count = (right[idx]-idx)*(idx - left[idx]);
            ans= (ans+ (count*arr[idx])%1000000007)%1000000007;
        }
        return (int)ans;
}


}*/

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
      
        Arrays.fill(left, -1);
        Arrays.fill(right, length);
      
        Deque<Integer> stack = new ArrayDeque<>();
      
        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
      
        stack.clear();
      
        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
      
        int mod = (int) 1e9 + 7;
        long answer = 0;
      
        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }
      
        return (int) answer;
    }
}
