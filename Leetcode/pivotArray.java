public class pivotArray {
   //[1,3,6,10,16]
   // [1,2,3,4,6]
    public static int getPivot(int arr[])
    {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum+= arr[i];
        }
        int leftsum = 0;
        for(int i = 0; i < arr.length; i++)
        {
          if(leftsum == sum - leftsum - arr[i]) return i;
          leftsum = leftsum + arr[i];
        }
        return -1;
    }
    public static void main(String args[])
    {
        int[] arr = new int[]{1,2,3,4,6};
        System.out.println(getPivot(arr));
    }
}
