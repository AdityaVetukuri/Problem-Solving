public class FactorialTrailZeros {

        public static int trailingZeroes(int n) {
            long factorial = getFactorial(n);
            System.out.println(factorial);
            int count = 0, res = 0;
            while(factorial > 0)
            {
                if(factorial % 10 == 0)
                    count++;
                else
                    count = 0;
                res  = Math.max(count, res);

                factorial = factorial / 10;
            }
            return res;
        }
        public static long getFactorial(int n)
        {
            if(n == 0)
                return 1;
            return n * getFactorial(n-1);
        }


    public static void main(String[] args) {
        int n = 10;
        trailingZeroes(n);
    }
}
