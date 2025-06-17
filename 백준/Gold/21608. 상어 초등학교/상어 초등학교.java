import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arr[][], N;
    static ArrayList<Integer>[] likes;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        arr = new int[N+1][N+1];

        likes = new ArrayList[(N*N)+1];
        Queue<Integer> seq = new LinkedList<>();

        for(int i =0; i<=N*N; i++) {
            likes[i] = new ArrayList<>();
        }

        for(int i =1; i<=N*N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int curStudentNumber = Integer.parseInt(st.nextToken());

            seq.add(curStudentNumber);
            for(int j =0; j<4; j++) {
                likes[curStudentNumber].add(Integer.parseInt(st.nextToken()));
            }
        }


        while(!seq.isEmpty()) {
            int currentSeq = seq.poll();

            int sit[] = findSit(currentSeq);
            int x=  sit[0];
            int y= sit[1];

            arr[x][y] = currentSeq;
        }

        System.out.println(findAnswer());
    }

    static int findAnswer() {
        int count =0;
        for(int i =1; i<=N; i++) {
            for(int j =1; j<=N; j++) {
                if (arr[i][j] == 0) continue;
                int value = getLikePeople(arr[i][j], i, j);

                if(value ==1) {
                    count+=1;
                }
                else if(value ==2) {
                    count+=10;
                }
                else if(value ==3) {
                    count+=100;
                }
                else if(value==4) {
                    count+=1000;
                }
            }
        }
        return count;
    }
    
    static int [] findSit(int currentSeq) {

        int likeCount = -1;
        int emptyCount = -1;
        int returnX = 1;
        int returnY = 1;
        for(int i =1; i<=N; i++) {
            for(int j =1; j<=N; j++) {
                if (arr[i][j] != 0) continue;
                int currentLikeCount = getLikePeople(currentSeq, i,j);
                int currentEmptyCount = emptyCount(i, j);
                if(likeCount < currentLikeCount) {
                    likeCount = currentLikeCount;
                    emptyCount = currentEmptyCount;
                    returnX = i;
                    returnY = j;
                }
                else if(likeCount == currentLikeCount) {
                    if(emptyCount < currentEmptyCount) {
                        emptyCount = currentEmptyCount;
                        returnX = i;
                        returnY = j;
                    }
                    else if(emptyCount == currentEmptyCount) {
                        continue;
                    }
                }
            }
        }
        return new int[] {returnX, returnY};
    }

    static int getLikePeople(int currentSeq, int x, int y) {
        ArrayList<Integer> list = likes[currentSeq];
        int count = 0;
        if(x-1 >=1) {
            if(list.contains(arr[x-1][y])) {
                count+=1;
            }
        }
        if(x+1<=N) {
            if(list.contains(arr[x+1][y])) {
                count+=1;
            }
        }

        if(y-1>=1) {
            if(list.contains(arr[x][y-1])) {
                count +=1;
            }
        }

        if(y+1 <=N) {
            if(list.contains(arr[x][y+1])) {
                count+=1;
            }
        }

        return count;
    }

    static int emptyCount(int x, int y) {
        int count = 0;
        if(x-1>=1 && arr[x-1][y] == 0) {
            count+=1;
        }
        if(x+1<=N && arr[x+1][y] == 0) {
            count+=1;
        }
        if(y-1>=1 && arr[x][y-1] == 0) {
            count+=1;
        }
        if(y+1<=N && arr[x][y+1] == 0) {
            count+=1;
        }
        return count;
    }
}
