public class BiWeeklyContest54 {
    public static int chalkReplacer(int[] chalk, int k) {
        int[] prefixSum = new int[chalk.length];
        prefixSum[0] = chalk[0];
        int sum = chalk[0];
        for(int i = 1; i < chalk.length; i++)
        {
            prefixSum[i] = prefixSum[i-1] + chalk[i]; // [3,7,8,10]
            sum += chalk[i]; // 10
        }
        while(k >= sum)
        {
            k = k - sum;  // 25 - > 15 -> 5
        }
        if(k == 0)
            return 0;
        int ans = binarySearch(0,chalk.length-1,k, prefixSum);
        return ans;

    }
    public static int binarySearch(int start, int end, int key, int[] arr)
    {
        if(end >= start)
        {
            int mid = start + (end - 1) / 2;
            if(arr[mid] == key)
                return mid + 1;
            else if(key > arr[mid])
                return binarySearch(mid +1, end, key, arr);
            else
                return binarySearch(start, mid -1, key, arr);
        }
        return start;
    }
    public static void main(String[] args) {
        int[] chalk = new int[]{22,25,39,3,45,45,12,17,32,9};
        int k = 835;
        chalkReplacer(chalk, k);
    }
}
