class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()) return false;
       int []f1 = getFrequency(s);
       int []f2 = getFrequency(t);

       for(int idx =0;idx<26;idx++){
        if(f1[idx] != f2[idx]) return false;
       }
       return true;
    }

    public int[] getFrequency(String str){
         int [] freq = new int[26];
        for(char ch: str.toCharArray()){
            freq[ch -'a']++;
        }
        return freq;
    }
}
