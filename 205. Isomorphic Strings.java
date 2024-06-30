class Solution {
  public boolean isIsomorphic(String s, String t) {
    return mapOneToOne(s,t)&& mapOneToOne(t,s);

  }
  public boolean mapOneToOne(String s1, String s2){
        char [] map = new char[256];
        for(int idx=0; idx<s1.length();idx++){
            char ch1 = s1.charAt(idx);
            char ch2 = s2.charAt(idx);

            if(map[ch1] != '\u0000' && map[ch1] != ch2 )return false;

            map[ch1] = ch2;
        }
        return true;

  }
}
