class Solution {
    public static class Pair{
        String word;
        int dist;

        Pair(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
       
    }
     public boolean hasEdge(String a, String b){
            int diff =0;
            for(int i=0; i<a.length();i++){
                if(a.charAt(i) != b.charAt(i))
                    diff++;
            }
            return (diff==1);
        }
    public int ladderLength(String src, String dest, List<String> dict) {
        if(dict.contains(dest) == false) return 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,1));

        HashMap<String,Integer> dist = new HashMap<>();

        while(q.size()>0){
            Pair p = q.remove();
            if(dist.containsKey(p.word) == true) continue;
            if(p.word.equals(dest) == true) return p.dist;

            dist.put(p.word, p.dist);

            for(String nbr: dict){
                if(hasEdge(p.word, nbr) == true)
                    q.add(new Pair(nbr, p.dist + 1));
            }
        }
        return 0;
    }
}
