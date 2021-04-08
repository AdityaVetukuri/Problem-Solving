import java.util.*;

class MatrixDistance {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {



        Pair[] arr = new Pair[R * C];

        int k = 0;
        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {

                int dist = Math.abs(r0 - i) + Math.abs(c0 - j);

                arr[k++] = new Pair(dist, new int[] { i, j });

            }

        }

        Arrays.sort(arr, new Comp());

        int[][] out = new int[arr.length][2];

        k = 0;
        for (Pair p : arr) {
            out[k++] = p.loc;
        }

        return out;

    }

    static class Comp implements Comparator<Pair> {

        public int compare(Pair a, Pair b) {

            if (a.dist > b.dist)
                return 1;
            if (a.dist < b.dist)
                return -1;

            return 0;
        }

    }

    static class Pair {
        int dist;
        int[] loc;

        public Pair(int dist, int[] loc) {
            this.dist = dist;
            this.loc = loc;
        }
    }

}