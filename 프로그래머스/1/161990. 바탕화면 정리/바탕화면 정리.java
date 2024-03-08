class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        answer = new int [4];
        int minx =999;
        int miny = 999;
        int maxx= 0;
        int maxy =0;
        for(int i =0; i<wallpaper.length; i++)
        {
            String str = wallpaper[i];
            
            for(int j =0; j<str.length(); j++)
            {
                if(str.charAt(j)=='#')
                {
                    if(minx>j)
                        minx =j;
                    if(miny>i)
                        miny=i;
                    if(maxx<j)
                        maxx=j;
                    if(maxy<i)
                        maxy=i;
                }
                
            }
            answer[0]= miny;
            answer[1]=minx;
            answer[2]=maxy+1;
            answer[3]=maxx+1;
        }
        
        return answer;
        
        
    }
}