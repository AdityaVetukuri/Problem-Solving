import java.util.*;
public class MaximumPopulation {
    public static int maximumPopulation(int[][] logs) {
        int pop[] = new int[2051], res = 0;
        for (var l : logs) {
            ++pop[l[0]];
            --pop[l[1]];
        }
        for (int i = 1950; i < 2050; ++i) {
            pop[i] += pop[i - 1];
            res = pop[i] > pop[res] ? i : res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] logs = new int[][]{{1950,1961},{1960,1971},{1970,1981}};
        maximumPopulation(logs);
    }
}
