import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<List<int[]>> paths = new ArrayList<>();
        
        Set<String> coll = new HashSet<>();
        for(int route[]: routes) {

            List<int []> currentPath = new ArrayList<>();
            
            for(int idx =0; idx< route.length-1; idx++) {
                int start[] = points[route[idx]-1];
                int end[] = points[route[idx+1]-1];
                
                List<int[]> path = getPath(start ,end);
                    if(idx > 0) {
        path.remove(0);  // 첫 구간 아니면 시작점 제거
    }
                currentPath.addAll(path);    
            }
            for(List<int[]> path: paths) {
                int size = path.size() > currentPath.size() ? currentPath.size() : path.size();

                for(int i =0; i<size; i++) {
                    int point1[] = path.get(i);
                    int point2[] = currentPath.get(i);
                    if(point1[0] == point2[0] && point1[1] == point2[1]) {
                        String str = point1[0] + "," + point1[1] +","+ i +"";
                        if(!coll.contains(str)) {
                            coll.add(str);
                            answer+=1;
                        }
                    }
                }
            }
            paths.add(currentPath);
        }
        
        return answer;
    }
    
    public List<int []> getPath(int start[], int end[]) {
        int startX = start[0];
        int startY = start[1];
        
        int endX = end[0];
        int endY = end[1];
        
        List<int[]> list = new ArrayList<>();
        
        list.add(new int[] {startX, startY});
        
        while(startX != endX) {
            if(startX < endX) startX++;
            else startX--;
            
            list.add(new int[] {startX, startY});
        }
        
        while(startY != endY) {
            if(startY < endY) startY++;
            else startY--; 
            list.add(new int[] {startX, startY});
        }
    
        return list;
    }
}