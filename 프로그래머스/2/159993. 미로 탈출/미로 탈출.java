import java.util.*;

class Solution {
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int startx;
    static int starty;
    static int levx;
    static int levy;
    static int endx;
    static int endy;
    static int[][] visit;
    static String[] mymap;
    public int solution(String[] maps) {
        int answer = 0;
        startx=0;
        starty=0;
        levx=0;
        levy=0;
        endx=0;
        endy=0;
        mymap = maps;
        visit = new int[maps.length][maps[0].length()];
        
        for(int i =0; i<maps.length; i++)
        {
            for(int j =0; j<maps[0].length(); j++)
            {
                visit[i][j]=-1;
            }
        }
        for(int i =0; i<maps.length; i++)
        {
            for(int j =0; j<maps[i].length(); j++)
            {
                if(maps[i].charAt(j) == 'S')
                {
                    startx=i;
                    starty=j;
                }
                else if(maps[i].charAt(j)== 'L')
                {
                    levx=i;
                    levy=j;
                }
                else if(maps[i].charAt(j) == 'E')
                {
                    endx=i;
                    endy=j;
                }
            }
        }
        
        bfs(startx , starty);
        if(visit[levx][levy]==-1)
            return -1;
        int lev =visit[levx][levy];
        for(int i =0; i<maps.length; i++)
        {
            for(int j =0; j<maps[0].length(); j++)
            {
                visit[i][j]=-1;
            }
        }
        visit[levx][levy]= lev;
        bfs(levx,levy);
        
        return  visit[endx][endy];
    
    }
    static void bfs(int x, int y)
    {
        Queue<int []> queue = new LinkedList<>();
        
        queue.add(new int[]{x,y});
        if(visit[x][y]==-1)
            visit[x][y]=0;
        
        while(!queue.isEmpty())
        {
            int []now = queue.poll();
            
            int nowx=  now[0];
            int nowy= now[1];
            
            for(int i =0; i<4; i++)
            {
                int nx = nowx+dx[i];
                int ny = nowy+dy[i];
                
                if(nx>=0 && ny >=0 && nx<mymap.length && ny <mymap[i].length() && visit[nx][ny] == -1 && mymap[nx].charAt(ny) !='X')
                {
                    visit[nx][ny]= visit[nowx][nowy]+1;
                    queue.add(new int[] { nx,ny});
                    
                    if(nx == levx && ny == levy)
                        return;
                }
            }
        }
        
    }
}