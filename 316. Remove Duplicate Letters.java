class Solution {
    public String removeDuplicateLetters(String s) {
        int [] freq= new int[26];
        boolean[] vis = new boolean[26];

        char[] chs = s.toCharArray();
        for(char ch: chs) freq[ch-'a']++;

        StringBuilder res = new StringBuilder();

        for(char ch: chs){
            freq[ch-'a']--;
            if(vis[ch-'a']== true) continue;
            vis[ch-'a'] = true;
            
            while(res.length() >0){
                char top = res.charAt(res.length() - 1);
                if(top> ch && freq[top-'a']>0){
                    res.deleteCharAt(res.length()-1);
                    vis[top-'a'] = false;
                }
                else break;
            }
          res.append(ch);
        }
      return res.toString();
    }
}
