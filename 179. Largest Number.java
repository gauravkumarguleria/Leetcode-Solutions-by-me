class Solution {
    public String largestNumber(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int val : nums) res.add(Integer.toString(val));
        Collections.sort(res,(t,o)->(o+t).compareTo(t+o));

        StringBuilder number = new StringBuilder();
        for(String str: res) number.append(str);
        if(number.charAt(0)=='0') return "0";
        return number.toString();
    }
}
