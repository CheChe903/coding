import java.util.*;
class Solution {
    static int[] dx ={0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static int count;
    static int[][] mypic;
    static int mym;
    static int myn;
        
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        mym=m;
        myn=n;
        
        mypic=picture;
        
        visited = new boolean[m][n];
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(visited[i][j]==false && mypic[i][j]>=1)
                {
                    count =0;
                    bfs(i,j);
                    numberOfArea++;
                }
                if(count>maxSizeOfOneArea)
                    maxSizeOfOneArea=count;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static void bfs(int x, int y)
    {
        Queue<int []> queue =new LinkedList<>();
        
        visited[x][y]=true;
        queue.add(new int[] {x,y});
        count++;
        
        while(!queue.isEmpty())
        {
            int []now = queue.poll();
            int nowx= now[0];
            int nowy = now[1];
            
            for(int i =0; i<4; i++)
            {
                int nx= nowx+dx[i];
                int ny = nowy+dy[i];
                
                if(nx>=0 && ny>=0 && nx<mym && ny<myn && visited[nx][ny]==false && mypic[nx][ny]==mypic[nowx][nowy])
                {
                    queue.add(new int[] { nx,ny});
                    visited[nx][ny]=true;
                    count++;
                }
            }
        }
    }
}