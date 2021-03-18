import java.util.*;
class CoinsPile {
    public static int maxCoins(int[] piles) {
        int counter = 1;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i< piles.length; i++)
        {
            pq.add(piles[i]);
        }
        while(!pq.isEmpty())
        {

            if(counter == 2)
            {
                counter = -1;
                sum = sum + pq.poll();
            }
            else
                pq.poll();
            counter++;
        }
        return sum;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{2,4,1,2,7,8};
        int result = maxCoins(arr);
    }
}