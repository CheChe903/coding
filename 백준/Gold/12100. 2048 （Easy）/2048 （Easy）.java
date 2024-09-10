import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(N==1) {
            System.out.println(arr[0][0]);
            System.exit(0);
        }

        dfs(0, arr);
        System.out.println(answer);
    }

    static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            updateAnswer(board);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] newBoard = move(board, dir);
            if (!isSameBoard(board, newBoard)) {
                dfs(depth + 1, newBoard);
            }
        }
    }

    static int[][] move(int[][] board, int dir) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, N);
        }

        switch (dir) {
            case 0: // 오른쪽
                moveRight(newBoard);
                break;
            case 1: // 왼쪽
                moveLeft(newBoard);
                break;
            case 2: // 위
                moveUp(newBoard);
                break;
            case 3: // 아래
                moveDown(newBoard);
                break;
        }

        return newBoard;
    }

    static void moveRight(int[][] board) {
        for (int i = 0; i < N; i++) {
            int[] row = new int[N];
            int idx = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (row[idx] == 0) {
                        row[idx] = board[i][j];
                    } else if (row[idx] == board[i][j]) {
                        row[idx] *= 2;
                        idx--;
                    } else {
                        idx--;
                        row[idx] = board[i][j];
                    }
                }
            }
            System.arraycopy(row, 0, board[i], 0, N);
        }
    }

    static void moveLeft(int[][] board) {
        for (int i = 0; i < N; i++) {
            int[] row = new int[N];
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    if (row[idx] == 0) {
                        row[idx] = board[i][j];
                    } else if (row[idx] == board[i][j]) {
                        row[idx] *= 2;
                        idx++;
                    } else {
                        idx++;
                        row[idx] = board[i][j];
                    }
                }
            }
            System.arraycopy(row, 0, board[i], 0, N);
        }
    }

    static void moveUp(int[][] board) {
        for (int j = 0; j < N; j++) {
            int[] col = new int[N];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                if (board[i][j] != 0) {
                    if (col[idx] == 0) {
                        col[idx] = board[i][j];
                    } else if (col[idx] == board[i][j]) {
                        col[idx] *= 2;
                        idx++;
                    } else {
                        idx++;
                        col[idx] = board[i][j];
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                board[i][j] = col[i];
            }
        }
    }

    static void moveDown(int[][] board) {
        for (int j = 0; j < N; j++) {
            int[] col = new int[N];
            int idx = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    if (col[idx] == 0) {
                        col[idx] = board[i][j];
                    } else if (col[idx] == board[i][j]) {
                        col[idx] *= 2;
                        idx--;
                    } else {
                        idx--;
                        col[idx] = board[i][j];
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                board[i][j] = col[i];
            }
        }
    }

    static void updateAnswer(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                answer = Math.max(answer, num);
            }
        }
    }

    static boolean isSameBoard(int[][] board1, int[][] board2) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board1[i][j] != board2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}