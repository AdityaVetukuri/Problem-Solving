import java.util.*;
class Order
{
    int price;
    int orders;
    public Order(int price, int orders)
    {
        this.price = price;
        this.orders = orders;
    }
}
class Contest {
    public static int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Integer> pq_buy = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> buy_map = new HashMap<>();
        HashMap<Integer, Integer> sell_map = new HashMap<>();
        PriorityQueue<Integer> pq_sell = new PriorityQueue<>();
        int backlog = 0;
        int n = orders.length;
        int l = orders[0].length;
        for(int i = 0; i < n; i++)
        {
           if(orders[i][2] == 0)
           {
               backlog = backlog + orders[i][1];
               buy_map.put(orders[i][0],orders[i][1]);
               pq_buy.add(orders[i][0]);
           }
           else
           {
               backlog = backlog + orders[i][1];
               sell_map.put(orders[i][0], orders[i][1]);
               pq_sell.add(orders[i][0]);
           }
        }
        while(!pq_buy.isEmpty() && !pq_sell.isEmpty() && pq_buy.peek() >= pq_sell.peek())
        {


              int buyval = pq_buy.poll();
              int sellval = pq_sell.poll();

              int buyItems = buy_map.get(buyval);
              int sellItems = sell_map.get(sellval);

              if(buyItems >= sellItems)
              {
                  buy_map.put(buyval,buyItems - sellItems);
                  backlog = backlog - ( 2 * sellItems);
                  if(buyItems!=sellItems)
                  pq_buy.add(buyval);
                  sell_map.remove(sellval);
              }
              else{
                  sell_map.put(sellval, sellItems - buyItems);
                  backlog = backlog - ( 2 * buyItems);
                  if(buyItems!=sellItems)
                      pq_sell.add(sellval);
                  buy_map.remove(buyval);
              }
            }

        return backlog;
    }
    public static void main(String args[])
    {
        int arr[][] = new int[][]{{7, 1000000000, 1}, {15,3,0}, {5,999999995,0}, {5,1,1}};
        getNumberOfBacklogOrders(arr);
    }
}