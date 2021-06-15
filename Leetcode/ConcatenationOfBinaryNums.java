public class ConcatenationOfBinaryNums {
    public static long concatenatedBinary(int n) {
        long ans = 0;
        int digits = 0;
        int mod = 1_000_000_007;
        for (int num = 1; num <= n; num++) {
            if ((num & (num - 1)) == 0) {
                ++digits;
            }
            ans = ((ans << digits) | num) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int n = 12;
        concatenatedBinary(n);
    }
}
