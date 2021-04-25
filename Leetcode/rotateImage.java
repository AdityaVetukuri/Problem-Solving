class rotateImage {
    public static void rotate(int[][] matrix) {
        rec(matrix, 0);
    }

    private static void rec(int[][] m, int l) {
        int n = m.length - 2 * l;
        int o = l + n - 1;
        if (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int temp2, temp1 = m[l + i][o];
                m[l + i][o] = m[l][l + i];
                temp2 = m[o][o - i];
                m[o][o - i] = temp1;
                temp1 = m[o - i][l];
                m[o - i][l] = temp2;
                m[l][l + i] = temp1;
            }
            rec(m, l + 1);
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(arr);
    }
}