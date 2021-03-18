
class sightSeeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int prev_max = 0;
        int sum = 0;
        int totalSum = 0;
        for(int i=0; i<values.length; i++)
        {
            sum = Math.max(sum, prev_max+values[i]-i);
            prev_max = Math.max(prev_max,i+values[i]);
        }
        return sum;
    }
}