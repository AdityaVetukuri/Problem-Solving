public class threeInversions {
    public static int getInversions(int arr[])
    {
        int inversions = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int small = 0;
            for(int j = i+1 ; j < arr.length; j++)
            {
                if(arr[i] > arr[j])
                    small++;
            }
            int big = 0;
            for(int j = i-1; j>= 0; j--)
            {
                if(arr[j] > arr[i])
                    big++;
            }
            inversions += small * big;
        }
        return inversions;
    }
    public static void main(String[] args)
    {
        int arr[] = new int[]{4,1,3,2,5};
        System.out.print(getInversions(arr));
    }
}
