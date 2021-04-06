import java.util.*;
public class AvoidFlood {
    public static int[] avoidFlood(int[] rains) {
        int res[] = new int[rains.length];
        Arrays.fill(res,1);

        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> emptyDays = new TreeSet<>();

        for(int i = 0; i < rains.length; i++)
        {
            int lake = rains[i];

            if(lake > 0)
            {
                res[i] = -1;
                if(map.get(lake) !=null)
                {
                    Integer emptyday = emptyDays.higher(map.get(lake));
                    if(emptyday == null)
                    {
                        return new int[0];
                    }
                    else
                    {
                        res[emptyday] = lake;
                        emptyDays.remove(emptyday);
                    }
                }
                map.put(lake,i);
            }
            else
            {
                emptyDays.add(i);
            }
        }
        return res;

    }
    public static void main(String args[])
    {
        int arr[] = new int[]{1,2,0,0,2,1};
        avoidFlood(arr);
    }
}
