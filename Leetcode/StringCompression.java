class StringCompression
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String res = "aabbaabb";//"ababcdababcd";
        int n = res.length();
        int i = n-1;
        while(i >= 0) {
            if(i%2 == 1) {
                if(res.substring(0 , i/2+1).equals(res.substring(i/2 + 1, i+1))) {
                    int k = res.length();
                    res = res.substring(0 , i/2 + 1)  + "*" + res.substring(i+1, k);
                    i = i/2;

                }
                else {
                    i--;
                }
            }
            else {
                i--;
            }
        }
        System.out.println(res);
    }
}