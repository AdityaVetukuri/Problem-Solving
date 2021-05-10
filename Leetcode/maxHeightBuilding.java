import java.util.*;
class maxHeightBuilding {
    public static int maxBuilding(int n, int[][] restrictions) {
        // If there are no restrictions, we will just keep increasing the height of next building till end 
        // and height of last building will be n - 1
        if (restrictions.length == 0)
            return n - 1;

        // sort the restrictions as per index
        Arrays.sort(restrictions, new Comparator<int[]>(){
            public int compare(int[] a, int[] v) {
                return Integer.compare(a[0], v[0]);
            }
        });

        int rLen = restrictions.length;

        // We might not always be able to reach the original restriction height at any given index.
        // Eg: [[3,5]]. Since height of building at id=1 will always be 0, height of building at id=3 can not be more than 2.
        // It can be less than 2 depending upon the limit of building on it's right.
        // Eg: [[3,5],[4,0]]. Here the height of duilding at id=3 will be 1 since building at id=4 have upper limit of height 0.

        // Update the limit while maintaining the restrictions and moving forward
        int pIndex = 1;
        int pHeight = 0;
        for(int[] res : restrictions) {
            res[1] = Math.min(res[1], pHeight + res[0] - pIndex);
            pIndex = res[0];
            pHeight = res[1];
        }

        // Update the limit while maintaining the restrictions and moving backward
        pIndex = n;
        pHeight = n - 1;
        for(int i = rLen - 1; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1], pHeight + pIndex - restrictions[i][0]);
            pHeight = restrictions[i][1];
            pIndex = restrictions[i][0];
        }

        // Calculate the maximum height between 2 restriction and compare it with global maximum.
        int maxHeight = 1;
        pIndex = 1;
        pHeight = 0;
        for(int[] restriction : restrictions) {
            int hDiff = Math.abs(pHeight - restriction[1]);
            int iDiff = restriction[0] - pIndex;
            int extraHeight = Math.abs((iDiff - hDiff) / 2);

            maxHeight = Math.max(maxHeight, Math.max(pHeight, restriction[1]) + extraHeight);

            pIndex = restriction[0];
            pHeight = restriction[1];
        }

        // If there is no restriction on height of last building, take it to max as much as possible
        if (restrictions[rLen - 1][0] != n) {
            maxHeight = Math.max(maxHeight, restrictions[rLen - 1][1] + n - restrictions[rLen - 1][0]);
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        int n = 10;
        int restrictions[][] = new int[][]{{5,3},{2,5},{7,4}};
        System.out.println(maxBuilding(n ,restrictions));
    }
}