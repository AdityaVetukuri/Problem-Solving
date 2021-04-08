import java.util.*;
public class PlatformsReq {
    public static int minPlatforms(int[] arrivals, int[] departures)
    {
        int max = Integer.MIN_VALUE;
        int platform = 1;
        for(int i = 0; i < arrivals.length; i++)
        {
            for(int j = i+1; j < departures.length; j++)
            {
                    if((arrivals[i] >= arrivals[j] && departures[i] <= departures[j]) || (arrivals[j] >= arrivals[i] && departures[j] <= departures[i]))
                    {
                        platform++;
                    }
            }
            max = Math.max(platform,max);
        }
        return max;
    }
    public static int optimizedMinPlatforms(int[] arrivals, int[] departures)
    {
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        int n = arrivals.length;
        int i = 1, j = 0;
        int max  = 1, platforms = 1;
        while(i < n && j  < n)
        {
            if(arrivals[i] >= departures[j])
            {
                platforms--;
                j++;
            }
            else if(arrivals[i] <= departures[j])
            {
                platforms++;
                i++;
            }
            max = Math.max(max, platforms);
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(optimizedMinPlatforms(arr,dep));
    }
}
