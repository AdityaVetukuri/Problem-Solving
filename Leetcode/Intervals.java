import java.util.*;
public class Intervals {
    int startTime;
    int endTime;
    int price;
    Intervals(int startTime, int endTime, int price)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }
    public static void main(String[] args) {
        List<Intervals> list = new ArrayList<>();
        Intervals obj1 = new Intervals(1,5,20);
        Intervals obj2 = new Intervals(3,8,15);
        Intervals obj3 = new Intervals(8,10,8);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list = getIntervals(list);
    }

    private static List<Intervals> getIntervals(List<Intervals> list) {
        Collections.sort(list, (a,b) -> a.startTime - b.startTime);
        List<Intervals> res = new ArrayList<>();
        int startTime = list.get(0).startTime;
        int endTime = list.get(0).endTime;
        int price = list.get(0).price;

        for(int i = 1; i < list.size(); i++)
        {
            Intervals current = list.get(i);
            if(current.startTime <= endTime && current.price < price)
            {
                res.add(new Intervals(startTime, current.startTime - 1, price));
                startTime = current.startTime;
                endTime = current.endTime;
                price = current.price;
            }
            else
            {
                res.add(new Intervals(startTime, endTime, price));
                startTime = current.startTime;
                endTime = current.endTime;
            }
        }

        res.add(new Intervals(startTime, endTime, price));
        return res;
    }
}
