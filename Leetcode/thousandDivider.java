class thousandDivider {
    public static String thousandSeparator(int n) {
        return pointDots(n,"");

    }
    public static String pointDots(int n, String str)
    {
        if( n == 0)
            return str;
        pointDots(n/10,  Integer.toString(n%10) + str);
        return "";
    }
    public static void main(String args[])
    {
        int n = 987;
        thousandSeparator(n);
    }
}