class maxLanguages {
    public static int minimumTeachings(int n, int[][] languages)    {
        int minLanguages = Integer.MAX_VALUE;
        for (int k = 1; k <=n; k++)
        {
            int currLanguages = 0;

            for(int i = 0; i < languages.length; i++)
            {
                boolean found = false;
                for(int j =0; j < languages[i].length;j++)
                {
                    if(languages[i][j] == k)
                    {
                        found = true;
                        break;
                    }
                }
                if(!found)
                    currLanguages += 1;
            }
            minLanguages = Math.min(currLanguages, minLanguages);
        }
        return minLanguages;
    }

    public static void main(String[] args) {
        int langs[][] = new int[][]{{3,11,5,10,1,4,9,7,2,8,6},{5,10,6,4,8,7},{6,11,7,9},{11,10,4},{6,2,8,4,3},{9,2,8,4,6,1,5,7,3,10},{7,5,11,1,3,4},{3,4,11,10,6,2,1,7,5,8,9},{8,6,10,2,3,1,11,5},{5,11,6,4,2}};
        System.out.println(minimumTeachings(2,langs));
    }
}