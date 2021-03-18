import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.*;

class fetchItemsToDisplay {
    String URL;
    int timestamp;
    int relevance;
    public fetchItemsToDisplay(String URL, int timestamp, int relevance) {
        this.URL = URL;
        this.timestamp = timestamp;
        this.relevance = relevance;
    }
    public static List<String> fetchResultsToDisplay(int sortColumn, int sortOrder, int resultsPerPage, int pageIndex, Map<String, int[]> results) {
    ArrayList<String> list = new ArrayList<>();
    ArrayList<fetchItemsToDisplay> items = new ArrayList<>();
    for(Map.Entry<String,int[]> entry : results.entrySet())
        items.add(new fetchItemsToDisplay(entry.getKey(),entry.getValue()[0],entry.getValue()[1]));
        if(sortColumn == 0)
        Collections.sort(items, new sortByURL());
        if(sortColumn == 1)
            Collections.sort(items,new sortByTimeStamp());
        if(sortColumn == 2)
            Collections.sort(items,new sortByTimeStamp());
        int index = pageIndex * resultsPerPage;
        for(int i =0 ;i < items.size(); i++)
        {
            if(i == index)
                System.out.println(items.get(i).URL);
        }
        return list;
    }
    static class sortByTimeStamp implements Comparator<fetchItemsToDisplay>
    {
        @Override
        public int compare(fetchItemsToDisplay o1, fetchItemsToDisplay o2) {
            return o1.timestamp - o2.timestamp;
        }
    }
    static class sortByRelevance implements Comparator<fetchItemsToDisplay>
    {

        @Override
        public int compare(fetchItemsToDisplay o1, fetchItemsToDisplay o2) {
            return o1.relevance - o2.relevance;
        }
    }
    static class sortByURL implements Comparator<fetchItemsToDisplay>
    {

        @Override
        public int compare(fetchItemsToDisplay o1, fetchItemsToDisplay o2) {
            return o1.URL.compareTo(o2.URL);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sortColumn = Integer.parseInt(scanner.nextLine());
        int sortOrder = Integer.parseInt(scanner.nextLine());
        int resultsPerPage = Integer.parseInt(scanner.nextLine());
        int pageIndex = Integer.parseInt(scanner.nextLine());
        int resultsLength = Integer.parseInt(scanner.nextLine());
        HashMap<String, int[]> results = new HashMap<>();
        for (int i = 0; i < resultsLength; i++) {
            String[] segs = scanner.nextLine().split(" ");
            results.put(segs[0], new int[] { Integer.parseInt(segs[1]), Integer.parseInt(segs[2]) });
        }
        scanner.close();
        List<String> res = fetchResultsToDisplay(sortColumn, sortOrder, resultsPerPage, pageIndex, results);
        System.out.println(String.join(" ", res));
    }
}
