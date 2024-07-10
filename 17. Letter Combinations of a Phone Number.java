class Solution{ 
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ways;
    public void printPaths(String digits, int idx, String output){
        if(idx == digits.length()){
            ways.add(output);
            return;
        }
        int digit = digits.charAt(idx) - '0';
        for(char letter : map[digit].toCharArray()){
            printPaths(digits, idx+1, output+ letter);
        } 
    }

    public List<String> letterCombinations(String digits) {
        ways = new ArrayList<>();
        if(digits.length() == 0) return ways;

        printPaths(digits, 0,"");
        return ways;
    }
}
