import java.util.*;
class buildHappyStrings {
    List<String> list = new ArrayList<>();
    public String getHappyString(int n, int k) {
        String str = "abc";
        prepareString(str,n,0,"");
        return list.size()>=k?list.get(k-1):"";

    }
    public void prepareString(String str, int n, int index, String curr)
    {
        if(curr.length() == n)
        {
            list.add(curr);
            return;
        }
        for(int i=0; i < str.length(); i++)
        {
            if(curr.length() > 0 && curr.charAt(curr.length()-1)==str.charAt(i))
                continue;
            prepareString(str, n,0,curr + str.charAt(i));
        }
    }

}