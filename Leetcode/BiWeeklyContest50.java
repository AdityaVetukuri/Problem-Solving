public class BiWeeklyContest50 {
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int last = (int)(Math.pow(2,maximumBit));
        int[] res = new int[nums.length];
        int xorSum = 0;
        for(int x : nums){
            xorSum ^= x;
        }
        for(int i = 0; i < nums.length; i++){
            res[i] = (xorSum ^ last - 1);
            xorSum ^= nums[nums.length - i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0,1,1,3};
        System.out.println(getMaximumXor(arr,2));
    }
}
