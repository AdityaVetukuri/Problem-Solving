class BattleShips {

    public static int countBattleships(char[][] board) {
        int battleShips = 0;
        for(int i = 0; i < board.length; i++)
        {
            for(int j =0; j < board[0].length; j++)
            {

                battleShips += dfs(board,i,j);

            }
        }
        return battleShips;
    }
    public static int dfs(char[][] board, int i, int j)
    {
        if(board[i][j] != 'X')
            return 0;
        else if(board[i][j] == 'X')
        {
            board[i][j] = 'Y';
            if(i < board.length - 1)
            {
                if(board[i+1][j] == 'X')
                    dfs(board,i+1,j);
            }
            if(j < board[0].length -1)
            {
                if(board[i][j+1] == 'X')
                    dfs(board,i,j+1);
            }
        }
        return 1;
    }
    public static void main(String args[])
    {
        char[][] board = new char[][]{{'X','.','.','X'},{'X','.','.','X'},{'.','.','.','X'}};
        countBattleships(board);
    }
}