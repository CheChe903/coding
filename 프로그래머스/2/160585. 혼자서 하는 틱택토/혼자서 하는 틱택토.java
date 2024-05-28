import java.util.*;

class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;

        for (String row : board) {
            for (char cell : row.toCharArray()) {
                if (cell == 'O') oCount++;
                if (cell == 'X') xCount++;
            }
        }

        if (oCount != xCount && oCount != xCount + 1) return 0;

        boolean oWins = checkWin(board, 'O');
        boolean xWins = checkWin(board, 'X');

        if (oWins && xWins) return 0;

        if (oWins && oCount != xCount + 1) return 0;

        if (xWins && oCount != xCount) return 0;

        return 1;
    }

    private boolean checkWin(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
        }
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;

        return false;
    }
}
