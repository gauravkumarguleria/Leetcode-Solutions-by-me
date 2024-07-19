class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int answer[] = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i++)
        {
           while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i])
           {
               int top = st.pop();
               answer[top] = i - top;
           }
           st.push(i);
        }
        return answer;
    }
}
