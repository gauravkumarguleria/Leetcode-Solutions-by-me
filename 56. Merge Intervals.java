
class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int[] interval: intervals)
            pq.add(new Pair(interval[0],interval[1]));
        
        List<Pair> res = new ArrayList<>();
        while(pq.size()>0){
            Pair curr = pq.remove();
            Pair last = (res.size()==0)? null:res.get(res.size()-1);

            if(last == null || last.end<curr.start)
                res.add(curr);
            else last.end = Math.max(last.end, curr.end);
        }

        int [][]mat = new int[res.size()][2];
        for(int i=0; i<res.size();i++){
            mat[i][0] = res.get(i).start;
            mat[i][1] = res.get(i).end;
        }
        return mat;
    }

    static class Pair implements Comparable<Pair>{
    int start,end;

    Pair(int start, int end){
        this.end =end ;
        this.start =start;
    }
    public int compareTo(Pair other){
        if(this.start < other.start) return -1;
        else if(this.start > other.start) return +1;
        return 0;
    }
}
}
