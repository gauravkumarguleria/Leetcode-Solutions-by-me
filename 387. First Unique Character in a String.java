class Solution {
    public int firstUniqChar(String s) {
     int freq[] = new int[26];

     //Fill the Frequency array
     for(char ch: s.toCharArray()){
        freq[ch-'a']++;
     }   

     //Find the First Unique or non repeating or distinct character
     for(int idx=0; idx<s.length();idx++){
        char ch = s.charAt(idx);
        if(freq[ch- 'a'] == 1) return idx;
     }
     return -1;
    }
}
