class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = n-1,j = 0, index = n-1;


        while(i >= j){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                result[index--] = nums[i] * nums[i];
                i--;
            }else{
                result[index--] = nums[j] * nums[j];
                j++;
            }
        }
        return result;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{-4,-1,0,3,10};
        arr = sortedSquares(arr);
    }
}