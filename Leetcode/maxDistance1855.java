public class maxDistance1855 {
    public static int maxDistance(int[] nums1, int[] nums2)
    {
        //55,30,5,4,2  100,20,10,10,5
        int maxDistance = 0;
        int ptr1 = 0; int ptr2 = 0;

        while(ptr1 < nums1.length && ptr2 < nums2.length)
        {
            if(nums1[ptr1] > nums2[ptr2])
            {
                if(ptr1 < ptr2)
                {
                    ptr1++;
                }
                else
                {
                    ptr1++;
                    ptr2++;
                }
            }
            else
            {
                maxDistance = Math.max(maxDistance, ptr2 - ptr1);
                ptr2++;
            }
        }
        return maxDistance;
    }
}
