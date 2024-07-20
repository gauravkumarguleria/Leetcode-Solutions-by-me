class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val: arr){
            if(pq.size()<k) pq.add(val);
            else if(val> pq.peek()){
                pq.remove();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
