import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }
        int mycol = col-1;
        
        Collections.sort(list, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[mycol] != o2[mycol]) {
                    return Integer.compare(o1[mycol], o2[mycol]);
                }
                else {
                    return Integer.compare(o2[0], o1[0]); 
                }
            }
        });
        
        for(int i = row_begin-1; i<=row_end-1; i++)
        {
            int sum =0;
            for(int j =0; j<list.get(i).length; j++)
            {
                sum += list.get(i)[j]%(i+1);

            }
            answer = answer ^ sum;
        }
        
        return answer;
    }
}
