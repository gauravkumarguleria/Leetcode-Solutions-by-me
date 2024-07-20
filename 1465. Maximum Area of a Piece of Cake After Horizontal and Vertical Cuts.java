 /*class Solution {

    public long getLength(long h , int[]cuts){
        List<Long> rows = new ArrayList<>();
        for(long val : cuts) rows.add(val);
        rows.add(0l); rows.add(h);
        Collections.sort(rows);

        long length = 0;
        for(int i =1; i<rows.size(); i++){
            long diff = rows.get(i) - rows.get(i-1);
            length= Math.max(length,diff);
        }
        return length;
    }

    public long getBreadth(long w , int[]cuts){
        List<Long> cols = new ArrayList<>();
        for(long val : cuts) cols.add(val);
        cols.add(0l); cols.add(w);
        Collections.sort(cols);

        long breadth = 0;
        for(int i =1; i<cols.size(); i++){
            long diff = cols.get(i) - cols.get(i-1);
            breadth= Math.max(breadth,diff);
        }
        return breadth;
    }


    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long length = getLength(h, horizontalCuts);
        long breadth = getBreadth(w, verticalCuts);
        int area = (int)((length*breadth)%(1000000007));
        return area;
    }
    
}
*/
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // Max Difference between any two horizontal cuts * Max Difference between any two vertical cuts will give the answer
        Arrays.sort(horizontalCuts); // to get consecutive cuts
        Arrays.sort(verticalCuts);
        long mod = (long)1e9+7;
        long a = 0,b = 0; // a = max diff of horizontal cuts b = max diff of vertical cuts
        int prev =0; // two edges of cake (0 - first cut)
        a = Math.max(a,h-horizontalCuts[horizontalCuts.length-1]); // and (edge - last cut) of the cake
        b = Math.max(b,w-verticalCuts[verticalCuts.length-1]);
        for(int i:horizontalCuts){
            a = Math.max(a,i-prev);
            prev = i;
        }
        prev = 0;
        for(int i:verticalCuts){
            b = Math.max(b,i-prev);
            prev = i;
        }
        return (int)((a*b)%mod);
    }
}
