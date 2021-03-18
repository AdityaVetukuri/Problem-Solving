import java.util.*;
class GoatLatin {
    public static String toGoatLatin(String S) {
        String arr[] = S.split(" ");
        String temp = "";
        for(int i =0; i<arr.length;i++)
        {
            String curr = arr[i];
            if(curr.charAt(0) == 'a' || curr.charAt(0) == 'e' || curr.charAt(0) == 'i'|| curr.charAt(0) == 'o'|| curr.charAt(0) == 'u' || curr.charAt(0) == 'A' || curr.charAt(0) == 'E' || curr.charAt(0) == 'I' || curr.charAt(0) == 'O'||curr.charAt(0) == 'U')
                curr = curr + "ma";
            else
                curr = curr.substring(1,curr.length()) +curr.charAt(0) + "ma";

            curr = curr + "a".repeat(i+1);
            temp = temp + curr+ " ";
        }
        return temp;
    }
    public static void main(String args[])
    {
        String str = "I speak Goat Latin";
        String result = toGoatLatin(str);
        System.out.println(result);

    }

}