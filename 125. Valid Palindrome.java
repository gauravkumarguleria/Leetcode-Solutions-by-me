class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int left = 0; int right = str.length() -1;

        while(left<=right){
            if(isAlphanumeric(str.charAt(left))== false)
                {
                    left++;
                    continue;
                }
            
             if(isAlphanumeric(str.charAt(right))== false)
                {
                    right--;
                    continue;
                }
            
             if(str.charAt(left)!=str.charAt(right))
                {
                return false;
                }
        left++; right--;


        }
        return true;
    }
    
    public boolean isAlphanumeric(char ch){
        if(ch>='a' && ch<='z') return true;
        if(ch>='A' && ch<='Z') return true;
        if(ch>='0' && ch<='9') return true;

        return false;
    }
}
