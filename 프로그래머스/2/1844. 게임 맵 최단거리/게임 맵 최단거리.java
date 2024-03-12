import java.util.*;

class Solution {
    static int[] dx ={0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] visited;
    static int lengthx,lengthy;
    static int[][] mymaps;
    public int solution(int[][] maps) {
        int answer = 0;
        
        visited =new int[maps.length+1][maps[0].length+1];
                
        mymaps = maps;
        lengthx = maps.length;
        lengthy= maps[0].length;
        bfs(0,0,0);
        System.out.println(lengthx +" " + lengthy);
        if(visited[lengthx-1][lengthy-1] ==0)
            return -1;
        else
            return visited[lengthx-1][lengthy-1];
        
        
    }
    
    static void bfs(int x, int y,int depth)
    {
        
        if(visited[x][y]!=0 || mymaps[x][y]!=1)
            return;
        
        Queue<int[]> queue =new LinkedList<>();
        
        queue.add(new int[]{x,y});
        
        visited[x][y]=depth+1;
        
        while(!queue.isEmpty())
        {
            int []now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            
            for(int i =0; i<4; i++)
            {
      
                int nx = nowx+dx[i];
                int ny = nowy+dy[i];

                
                if(nx>=0 && ny >=0 && nx<lengthx && ny<lengthy)
                {
                    if(visited[nx][ny]==0 && mymaps[nx][ny]==1)
                    {
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny]= visited[nowx][nowy]+1;
                    }
                }
            }
        }
    }
}