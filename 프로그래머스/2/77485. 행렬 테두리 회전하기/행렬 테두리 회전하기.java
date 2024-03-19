import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        answer=new int[queries.length];
        int[][] arr = new int[rows+5][columns+5];
        int cur=1;
        for(int i =1; i<=rows; i++)
        {
            for(int j =1; j<=columns; j++)
            {
                arr[i][j]=cur++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<queries.length; i++)
        {
            int startx = queries[i][0];
            int starty = queries[i][1];
            int endx = queries[i][2];
            int endy = queries[i][3];

            int x =startx;
            int y =starty;
            int min =arr[x][y];
            queue.add(arr[x][y]);
            while(y+1<=endy)
            {
                y++;
                queue.add(arr[x][y]);
                if(min>arr[x][y])
                    min=arr[x][y];
            }

            while(x+1<=endx)
            {
                x++;
                queue.add(arr[x][y]);
                if(min>arr[x][y])
                    min=arr[x][y];
            }

            while(y-1>=starty)
            {
                y--;
                queue.add(arr[x][y]);
                if(min>arr[x][y])
                    min=arr[x][y];
            }
            while(x-1>startx)
            {
                x--;
                queue.add(arr[x][y]);
                if(min>arr[x][y])
                    min=arr[x][y];
            }
            x =startx;
            y =starty+1;

            arr[x][y]=queue.poll();
            
            while(!queue.isEmpty())
            {
                while(!queue.isEmpty()&&y+1<=endy)
                {
                    y++;
                    arr[x][y]=queue.poll();
                }

                while(!queue.isEmpty()&&x+1<=endx)
                {
                    x++;
                    arr[x][y]=queue.poll();
                }

                while(!queue.isEmpty()&&y-1>=starty)
                {
                    y--;
                    arr[x][y]=queue.poll();
                }
                while(!queue.isEmpty()&&x-1>=startx)
                {
                    x--;
                    arr[x][y]=queue.poll();
                }
            }
            answer[i]=min;

        }

        return answer;
    }
}