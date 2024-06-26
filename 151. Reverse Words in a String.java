class Solution {
    public String reverseWords(String s) {
   /* 
    String []words =  s.split("\s+");
    StringBuilder str = new StringBuilder();
    for(int idx = words.length-1;idx>=0;idx--){
      
        str.append(" "+words[idx]);
    }
   return  str.toString().trim();
*/

//TWO POINTER LOGIC

        int right = s.length() -1;
        StringBuilder res = new StringBuilder();

        //iterate on all words
        while(right>=0){

            while(right>=0 && s.charAt(right)== ' ')
                right--;
            
            int left = right;

            while(left>=0 && s.charAt(left)!=' ')
            {
                left--;
            }

            if(res.length()>0&& left<right){
                res.append(" ");
            }

            for(int idx=left +1; idx<=right; idx++){
                res.append(s.charAt(idx));

            }

            right = left;
        }

        return res.toString();
    }
}
