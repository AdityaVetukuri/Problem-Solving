public class SingleDigit {
    public static  int singleNumber(int[] nums) {
        int res=0;
        for(int i:nums){
            res^=i;
        }
        return res;
    }
    public static void main(String args[])
    {
        int[] nums = new int[]{4,1,2,1,2};
        int result = singleNumber(nums);
    }
}
