import java.util.*;

class Solution {
    static boolean[][] visited;
    static String[] mymap;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count;
    public int[] solution(String[] maps) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        mymap = maps;
        
        visited =new boolean[mymap.length][mymap[0].length()];
        
        for(int i =0; i<mymap.length; i++)
        {
            for(int j =0; j<mymap[i].length(); j++)
            {
                count =0;
                if(visited[i][j]==false && mymap[i].charAt(j)!='X')
                {
                    
                    dfs(i,j);
                    list.add(count);
                }
                    
                
            }
        }
        answer = new int[list.size()];
        int cur =0;
        for(Integer num : list)
        {
            answer[cur]=num;
            cur++;
        }
        if(list.size()==0)
        {
            answer = new int[1];
            answer[0]=-1;
        }
            
        Arrays.sort(answer);
        return answer;
    }
    
    static void dfs(int x, int y)
    {
        Queue<int[]> queue = new LinkedList<>();
        
        visited[x][y] = true;
        count += mymap[x].charAt(y) - '0';
        queue.add(new int[] { x,y});
        
        while(!queue.isEmpty())
        {
            
            int []now = queue.poll();
            
            int nowx = now[0];
            int nowy = now[1];
            
            for(int i =0; i<4; i++)
            {
                int nx = nowx+dx[i];
                int ny = nowy+dy[i];
                if(nx>=0 && ny >=0 && nx<mymap.length && ny <mymap[0].length())
                {
                    if(mymap[nx].charAt(ny) !='X' &&visited[nx][ny]==false)
                    {
                        count += mymap[nx].charAt(ny) - '0';
                        queue.add(new int[] {nx,ny});
                        visited[nx][ny]=true;
                    }
                }
            }
            
            
            
        }
        
    }
}