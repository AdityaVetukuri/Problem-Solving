public class NumOfSubArraysKgreater {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int windowStart = 0, sum  = 0, count = 0, average = 0;
            for(int windowEnd = 0; windowEnd < arr.length; windowEnd++)
            {
                if(windowEnd >= k)
                {
                    sum = sum - arr[windowStart];
                    windowStart++;
                }
                sum += arr[windowEnd];
                average = average / k;
                if(average >= threshold)
                    count++;
            }
            return count;
        }

    public static void main(String[] args) {
        
    }
}
