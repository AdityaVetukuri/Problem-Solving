import java.util.*;
class RPN {
    public static  int evalRPN(String[] tokens) {
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))
            {

                int value2 = st.pop();
                int value1 = st.pop();

                if(tokens[i].equals("+"))
                {
                    result = value1 + value2;
                    st.push(result);
                }
                else if(tokens[i].equals("*"))
                {
                    result = value1 * value2;
                    st.push(result);
                }
                else if(tokens[i].equals("/"))
                {
                    result = value1 / value2;
                    st.push(result);
                }
                else
                {
                    result = value1 - value2;
                    st.push(result);
                }
            }
            else
            {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
    public static void main(String args[])
    {
        String arr[] = new String[]{"4","13","5","/","+"};
        int result = evalRPN(arr);
        System.out.println(result);
    }
}