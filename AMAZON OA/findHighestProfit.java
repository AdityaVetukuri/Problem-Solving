import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

class findHighestProfit {
    public static int findProfit(List<Integer> inventory, int order) {
        // WRITE YOUR BRILLIANT CODE HERE
        int profit =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : inventory)
        {
            pq.add(i);
        }
        while(order!=0)
        {
            int value = pq.poll();
            profit = profit + value;
            pq.add(value-1);
            order--;
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inventory = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int order = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findProfit(inventory, order);
        System.out.println(res);
    }
}
