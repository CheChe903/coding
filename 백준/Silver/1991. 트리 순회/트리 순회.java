import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Character> A[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[26];
        
        // 배열 초기화
        for (int i = 0; i < 26; i++) {
            A[i] = new ArrayList<>();
        }
        
        // 입력 처리
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] splitInput = input.split(" ");
            
            char root = splitInput[0].charAt(0);

            // 왼쪽 자식 노드가 있을 때 추가
            if (!splitInput[1].equals(".")) {
                A[root - 'A'].add(splitInput[1].charAt(0));
            } else {
                A[root - 'A'].add('.');  // 왼쪽 자식이 없을 때 '.' 추가
            }

            // 오른쪽 자식 노드가 있을 때 추가
            if (!splitInput[2].equals(".")) {
                A[root - 'A'].add(splitInput[2].charAt(0));
            } else {
                A[root - 'A'].add('.');  // 오른쪽 자식이 없을 때 '.' 추가
            }
        }

        char root = 'A';
        preOrder(root);   // 전위 순회
        System.out.println();
        inOrder(root);    // 중위 순회
        System.out.println();
        postOrder(root);  // 후위 순회
    }

    // 전위 순회
    static void preOrder(char c) {
        if (c == '.') return;  // 자식이 없음을 의미할 때 반환

        System.out.print(c); // 루트 노드 출력
        if (A[c - 'A'].get(0) != '.') { // 왼쪽 자식이 있는 경우
            preOrder(A[c - 'A'].get(0));
        }
        if (A[c - 'A'].get(1) != '.') { // 오른쪽 자식이 있는 경우
            preOrder(A[c - 'A'].get(1));
        }
    }

    // 중위 순회
    static void inOrder(char c) {
        if (c == '.') return;  // 자식이 없음을 의미할 때 반환

        if (A[c - 'A'].get(0) != '.') { // 왼쪽 자식이 있는 경우
            inOrder(A[c - 'A'].get(0));
        }
        System.out.print(c); // 루트 노드 출력
        if (A[c - 'A'].get(1) != '.') { // 오른쪽 자식이 있는 경우
            inOrder(A[c - 'A'].get(1));
        }
    }

    // 후위 순회
    static void postOrder(char c) {
        if (c == '.') return;  // 자식이 없음을 의미할 때 반환

        if (A[c - 'A'].get(0) != '.') { // 왼쪽 자식이 있는 경우
            postOrder(A[c - 'A'].get(0));
        }
        if (A[c - 'A'].get(1) != '.') { // 오른쪽 자식이 있는 경우
            postOrder(A[c - 'A'].get(1));
        }
        System.out.print(c); // 루트 노드 출력
    }
}
