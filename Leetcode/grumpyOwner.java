class grumpyOwnder {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int grumpySum = 0, sum = 0;
        int maxGrumpy = 0;
        for(int i = 0; i < X; i++)
        {
            if(grumpy[i] == 1)
                grumpySum += customers[i];
            else
                sum += customers[i];

        }
        maxGrumpy = Math.max(grumpySum,maxGrumpy);
        for(int i = X; i < customers.length; i++)
        {
            if(grumpy[i] == 1)
            {
                if(grumpy[i-X] == 1)
                {
                    maxGrumpy = Math.max(maxGrumpy, grumpySum + customers[i] -customers[i-X]);
                    grumpySum = grumpySum + customers[i] - customers[i-X];
                }
                else
                {

                    maxGrumpy = Math.max(maxGrumpy, grumpySum + customers[i]);
                    grumpySum = grumpySum + customers[i];
                }
            }
            else
            {
                sum += customers[i];
                if(grumpy[i-X] == 1)
                {
                    grumpySum = grumpySum - customers[i-X];
                }
            }
        }
        return sum + maxGrumpy;
    }

    public static void main(String[] args) {
        int customers[] = new int[]{9,10,4,5};
        int grumpy[] = new int[]{1,0,1,1};
        int X = 1;
        System.out.println(maxSatisfied(customers,grumpy,X));

    }
}