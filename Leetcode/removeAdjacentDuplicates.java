import java.util.*;
public class removeAdjacentDuplicates {
    public static String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();
        st.push(S.charAt(0));
        for(int i = 1; i < S.length(); i++)
        {
            if((!st.isEmpty()) && st.peek() == S.charAt(i))
                st.pop();
            else
                st.push(S.charAt(i));
        }
        String temp = "";
       while(!st.isEmpty())
       {
           temp += st.pop();
       }
       String revTemp = "";
       for(int i = temp.length()-1; i >= 0; i--)
       {
           revTemp += temp.charAt(i);
       }
       return revTemp;
    }

    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
    }
}
