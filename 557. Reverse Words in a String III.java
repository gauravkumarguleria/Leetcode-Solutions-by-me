class Solution {
    public String reverseWords(String s) {
       char res[] = s.toCharArray();
       int left=0;
       while(left<s.length()){
        int right = left;

        while(right<s.length() && res[right] != ' '){
            right++;
        }

        reverse(res,left,right-1);
        left = right +1;
       }
       return String.valueOf(res);
    }

    public void reverse(char[] res, int left, int right){
        while(left<=right){
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left++; right--;;
        }
    }
    
}
