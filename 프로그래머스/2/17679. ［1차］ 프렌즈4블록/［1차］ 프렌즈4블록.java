import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] boardArr = new char[m][n];
        for (int i = 0; i < m; i++) {
            boardArr[i] = board[i].toCharArray();
        }
        
        while (true) {
            boolean[][] visited = new boolean[m][n];
            List<int[]> blocksToRemove = new ArrayList<>();
            
            // 2x2 형태의 사라질 블록을 찾음
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char block = boardArr[i][j];
                    if (block != ' ' && 
                        block == boardArr[i][j+1] &&
                        block == boardArr[i+1][j] &&
                        block == boardArr[i+1][j+1]) {
                        visited[i][j] = visited[i][j+1] = visited[i+1][j] = visited[i+1][j+1] = true;
                        blocksToRemove.add(new int[]{i, j});
                    }
                }
            }
            
            // 사라질 블록 제거 및 개수 카운트
            if (blocksToRemove.isEmpty()) break;
            for (int[] block : blocksToRemove) {
                int row = block[0];
                int col = block[1];
                if (boardArr[row][col] != ' ') {
                    boardArr[row][col] = ' ';
                    answer++;
                }
                if (boardArr[row][col+1] != ' ') {
                    boardArr[row][col+1] = ' ';
                    answer++;
                }
                if (boardArr[row+1][col] != ' ') {
                    boardArr[row+1][col] = ' ';
                    answer++;
                }
                if (boardArr[row+1][col+1] != ' ') {
                    boardArr[row+1][col+1] = ' ';
                    answer++;
                }
            }
            
            // 빈 공간을 채움 (블록을 아래로 내림)
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (boardArr[i][j] == ' ') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (boardArr[k][j] != ' ') {
                                boardArr[i][j] = boardArr[k][j];
                                boardArr[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
