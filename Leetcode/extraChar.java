public class extraChar {
    public char findTheDifference(String s, String t) {
        int scount=0;
        int tcount = 0;
        for(int i=0;i<t.length();i++){
            if(i<s.length()){
                scount+=s.charAt(i);
            }
            tcount+=t.charAt(i);
        }
        return (char)(tcount-scount);
    }
    public static void main(String args[])
    {
        String s = "abcd";
        String t = "abcde";
    }
}
