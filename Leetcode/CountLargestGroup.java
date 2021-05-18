import java.util.*;
public class CountLargestGroup {
    public static int countLargestGroup(int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 1; i < n; i++)
        {

            if(i % 9 == 0)
            {
                if(map.get(9) == null)
                {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(9);
                    map.put(i,list);
                }
                else {
                    ArrayList<Integer> list  = map.get(9);
                    list.add(i);
                    map.put(9, list);
                }
            }
            else
            {
                if(map.get(i % 9) == null)
                {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(i, list);
                }
                else {
                    ArrayList<Integer> list = map.get(i % 9);
                    list.add(i % 9);
                    map.put(i, list);

                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int n = 13;
        countLargestGroup(n);

    }

}
