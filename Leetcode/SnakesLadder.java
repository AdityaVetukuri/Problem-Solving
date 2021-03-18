import java.util.*;
class SnakesLadder {
    public int snakesAndLadders(int[][] board) {

        //corner case
        if(board == null || board.length == 0)return 0;

        int n = board.length;
        int k = 1;

        boolean[] visited = new boolean[n*n + 1];
        int[] nums = new int [n*n + 1];

        while(k <= n*n){

            int row = n - 1 - (k -1)/n;
            int col =((k-1)/n % 2 == 0)?(k-1) % n : (n-1)-(k-1) % n;

            nums[k++]= board[row][col];
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();

                if(cur == n*n) return steps;
                for(int j = 1; j <= 6 && cur + j <= n*n; j++){
                    int num1 = nums[cur + j];
                    int loca = (num1 == -1) ? cur+j: num1;

                    if(!visited[loca]){
                        visited[loca] = true;
                        queue.offer(loca);
                    }
                }
            }

            steps++;
        }
        return -1;
    }
}