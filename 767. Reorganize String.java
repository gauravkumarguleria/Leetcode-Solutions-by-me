class Solution {
    static class Pair implements Comparable<Pair>{
        char ch; int freq;

        public Pair(char ch,int freq){
            this.ch = ch;
            this.freq=freq;
        }
        public int compareTo(Pair other){
            if(this.freq< other.freq) return +1;
            else if(this.freq > other.freq) return -1;
            else return 0;
        }
    }
    public String reorganizeString(String s) {
        Pair[] pairs = new Pair[26];
        for(int i=0; i< 26; i++){
            pairs[i] = new Pair((char)(i + 'a'),0);
        }
        for(char ch: s.toCharArray()){
            pairs[ch -'a'].freq++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Pair p : pairs)
            if(p.freq >0) pq.add(p);

        Pair prev = new Pair('#',0);
        StringBuilder res = new StringBuilder();

        while(pq.size()>0){
            Pair curr = pq.remove();
            res.append(curr.ch);
            curr.freq--;

            if(prev.freq > 0) pq.add(prev);
            prev=curr;
        }

        if(prev.freq>0) return "";
        return res.toString();

    }
}
