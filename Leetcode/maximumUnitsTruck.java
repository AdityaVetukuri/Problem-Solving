import java.util.*;
public class maximumUnitsTruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> a[1] - b[1]);
        int res = 0;
        int canTake = 0;
        for(int i = boxTypes.length-1; i >= 0; i--)
        {
            if(truckSize <= 0)
                break;
            canTake = truckSize - boxTypes[i][0];
            if(canTake > 0)
                res += boxTypes[i][0] * boxTypes[i][1];
            else
            {
                res += truckSize * boxTypes[i][1];
            }
            truckSize = truckSize - boxTypes[i][0];
        }
        return res;
    }

    public static void main(String[] args) {
        int boxTypes[][] = new int[][]{{1,3},{2,2},{3,1}};
        int truckSize = 4;
        maximumUnits(boxTypes, truckSize);
    }

}
