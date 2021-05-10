public class StockPurchase {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int sell = 0;

        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] < buy)
            {
                profit += sell - buy;
                sell = 0;
                buy = prices[i];
            }
            else
            {
                sell = Math.max(sell, prices[i]);
            }
        }
        return profit;
    }
    public static void main(String[] args) {
    int[] arr = new int[]{7,1,5,3,6,4};
    System.out.println(maxProfit(arr));
    }
}
