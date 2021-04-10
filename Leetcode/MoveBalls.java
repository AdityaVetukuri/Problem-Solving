class MoveBalls {
    public int[] minOperationsOptimized(String boxes) {

        int left = 0, right = 0, rightSum = 0, leftSum = 0, n = boxes.length();

        for(int i = 0; i < n; i++)
        {
            if(boxes.charAt(i) == '1')
            {
                right++;
                rightSum += i;
            }
        }
        int res[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            res[i] = leftSum + rightSum;

            if(boxes.charAt(i) == '1')
            {
                left++;
                right--;
            }
            leftSum = leftSum + left;
            rightSum = rightSum - right;
        }
        return res;
    }
    public int[] minOperations(String boxes)
    {
        int n = boxes.length();
        int res[] = new int[n];

        for(int i = 0; i < n;i++)
        {
            int ptr1 = i-1;
            int ptr2 = i+1;
            int ans = 0;
            for(int l = i-1; l >= 0; l--)
            {
                if(boxes.charAt(l) == '1')
                    ans = ans + (i - l);
            }
            for(int r = i+1; r < n ; r++)
            {
                if(boxes.charAt(r) == '1')
                    ans = ans + (r - i);
            }
            res[i] = ans;
        }
        return res;
    }
}