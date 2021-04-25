import java.util.*;
class UglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;

        int[] mul = new int[m];

        Arrays.fill(mul, 0);

        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;

            int temp1 = -1;

            for (int j = 0; j < m; j++) {
                int temp2 = dp[mul[j]] * primes[j];

                if (dp[i] > temp2) {
                    dp[i] = temp2;

                    temp1 = j;
                } else if (dp[i] == temp2)
                    mul[j] = mul[j] + 1;
            }

            mul[temp1] = mul[temp1] + 1;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 12;
        int primes[] = new int[]{2,7,13,19};
        System.out.println(nthSuperUglyNumber(n,primes));
    }
}