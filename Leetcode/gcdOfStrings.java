class gcdOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }

        // If str1 is not the
        // concatenation of str2
        else if (!str1.startsWith(str2)) {
            return "";
        }

        else if (str2.isEmpty()) {

            // GCD string is found
            return str1;
        }
        else {

            // Cut off the common prefix
            // part of str1 & then recur
            return gcdOfStrings(str1.substring(str2.length()),
                    str2);
        }
    }
    public static void main(String[] args)
    {
        String s1 = "ABABAB";
        String s2 = "ABAB";
        gcdOfStrings(s1,s2);
    }
}