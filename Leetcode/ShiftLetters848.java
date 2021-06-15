public class ShiftLetters848 {
    public static void main(String[] args) {
        int arr[] = new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        String str  = "mkgfzkkuxownxvfvxasy";
        shiftingLetters(str,arr);
    }

    private static String shiftingLetters(String str, int[] arr) {
        StringBuilder res = new StringBuilder();

        long sum  = 0;
        for(int i = arr.length - 1; i >=0; i--)
        {
            sum += arr[i];
            char c = str.charAt(i);
            long val = (int) c -'a'  + sum;
            if(val > 26)
                val = val % 26;
            c = (char) (val + 'a');
            res.insert(0, c);
        }
        return res.toString();
    }

}
