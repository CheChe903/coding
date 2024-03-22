class Solution {
    public int solution(String dirs) {
        int answer = 0;

        int startx= 10;
        int starty =10;
        boolean up[][] = new boolean[16][16];
        boolean down[][] = new boolean[16][16]; 
        boolean left[][] = new boolean[16][16]; 
        boolean right[][] = new boolean[16][16]; 
        for(int i =0; i<dirs.length(); i++)
        {
            char go = dirs.charAt(i);

            if(go == 'U')
            {
                if(startx-1>=5)
                {
                    startx-=1;
                    if(up[startx][starty]==false && down[startx+1][starty]==false)
                    {
                        answer++;
                        up[startx][starty]=true;
                    }
                }
            }
            else if(go == 'D')
            {
                if(startx+1<=15)
                {
                    startx+=1;
                    if(down[startx][starty]==false && up[startx-1][starty]==false)
                    {
                        answer++;
                        down[startx][starty]=true;
                    }
                }
            }
            else if(go == 'L')
            {
                if(starty-1>=5)
                {
                    starty-=1;
                    if(left[startx][starty]==false && right[startx][starty+1]==false)
                    {
                        answer++;
                        left[startx][starty]=true;
                    }
                }
            }
            else if(go == 'R')
            {
                if(starty+1<=15)
                {
                    starty+=1;
                    if(right[startx][starty]==false && left[startx][starty-1]==false)
                    {
                        answer++;
                        right[startx][starty]=true;
                    }
                }
            }
        }

        return answer;
    }
}