class Solution {
    //Simply KMP algorithm
    public String longestPrefix(String s) {
        int[] ans = new int[s.length()];       
        int prefix = 0, suffix = 1;

        while(suffix<s.length()){
            if(s.charAt(prefix) == s.charAt(suffix)){
                ans[suffix] = prefix + 1;
                prefix++; suffix++;
            }
            else{
                if(prefix == 0){
                    ans[suffix] = 0;
                    suffix++;
                }
                else{
                    prefix = ans[prefix - 1];
                }

            }
        }
        return s.substring(0,prefix);
    }
}
