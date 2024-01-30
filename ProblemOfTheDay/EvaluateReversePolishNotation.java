import java.util.Stack;

public class EvaluateReversePolishNotation {
    class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) 
            {
                String s2 = st.pop();
                int b = Integer.parseInt(s2);
                String s1 = st.pop();
                int a = Integer.parseInt(s1);
                int c = 0;
                if(s.equals("+"))
                {
                    c = a + b;
                }
                else if(s.equals("-"))
                {
                    c = a - b;
                }
                else if(s.equals("*"))
                {
                    c = a * b;
                }
                else 
                {
                    c = a / b;
                }
                st.push(Integer.toString(c));
            }
            else 
            {
                st.push(tokens[i]);
            }
       }
       String res = st.pop();
       return Integer.parseInt(res);

    }
}
}
