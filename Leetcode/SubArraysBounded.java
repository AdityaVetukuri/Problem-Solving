class SubArraysBounded {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int i = 0, j = 0, max = Integer.MIN_VALUE, prev = 0, ans = 0;
        int n = A.length;
        while(j < n)
        {
            if(A[j] > R)
            {
                max = Integer.MIN_VALUE;
                prev = 0;
                j++;
                i = j;
            }
            else if(A[j] < L)
            {
                ans += prev;
                j++;
            }
            else
            {
                max = Math.max(max,A[j]);
                if(max>=L && max<=R)
                {

                    prev = j-i + 1;
                    ans += prev;
                    j++;
                }
            }
        }
        return ans;
    }
}