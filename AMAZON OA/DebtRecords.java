import java.util.*;

class DebtRecords {
    public static List<String> debtRecords(List<List<String>> debts) {
        // WRITE YOUR BRILLIANT CODE HERE
        HashMap<String,Integer> map = new HashMap<>();
        int maximumDebt = Integer.MAX_VALUE;
        for(List<String> debt : debts)
        {
            String borrower = debt.get(0);

            int borrowDebt = Integer.parseInt(debt.get(2));
            if(map.get(borrower) == null)
            {
                map.put(borrower,-borrowDebt);
            }
            else
            {
                map.put(borrower,map.get(borrower) - borrowDebt);
            }
            String lender = debt.get(1);
            int lendDebt = Integer.parseInt(debt.get(2));
            if(map.get(lender) == null)
            {
                map.put(lender,lendDebt);
            }
            else
            {
                map.put(lender,map.get(lender) + lendDebt);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer>
                entry : map.entrySet())
        {
            int value = entry.getValue();
            if(value < maximumDebt)
            {
                maximumDebt = value;
            }
        }
        for (Map.Entry<String, Integer>
                entry : map.entrySet())
        {
            int value = entry.getValue();
            String key = entry.getKey();
            if(value == maximumDebt)
            {
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int debtsLength = Integer.parseInt(scanner.nextLine());
        List<List<String>> debts = new ArrayList<>();
        for (int i = 0; i < debtsLength; i++) {
            debts.add(Arrays.asList(scanner.nextLine().split(" ")));
        }
        scanner.close();
        List<String> res = debtRecords(debts);
        System.out.println(String.join(" ", res));
    }
}
