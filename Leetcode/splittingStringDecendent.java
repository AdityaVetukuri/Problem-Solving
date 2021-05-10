public class splittingStringDecendent {
    public static boolean splitStrings(String str)
    {
        return isRemainingValid(str, null);
    }

    private static boolean isRemainingValid(String str, Long previous) {
        long current = 0;
        for(int i = 0; i < str.length(); i++)
        {
            current = current * 10 + str.charAt(i) - '0';
            if(previous == null) {
                if (isRemainingValid(str.substring(i + 1), current))
                    return true;
            }else if(current == previous - 1 && (i == str.length() - 1 || isRemainingValid(str.substring(i+1),current)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "050043";
        splitStrings(str);
    }
}
