import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int dia = picks[0];
        int iro = picks[1];
        int sto = picks[2];
        
        int total = dia + iro + sto;
        
        int len = (minerals.length % 5 == 0) ? minerals.length / 5 : minerals.length / 5 + 1;
        int mineralGroup[][] = new int [len][6];
        
        if(total*5 < len *5)
            len = total;
        
        
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                int idx = i * 5 + j;
                if (idx >= minerals.length) break;
                if (minerals[idx].equals("diamond"))
                {
                    sum += 25;
                    mineralGroup[i][j] = 25;
                }
                else if (minerals[idx].equals("iron"))
                {
                    sum += 5;
                    mineralGroup[i][j]=5;
                }
                else
                {
                    sum +=1;
                    mineralGroup[i][j]=1;
                }
            }
            mineralGroup[i][5] = sum;
        }
        
        Arrays.sort(mineralGroup, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[5] - o1[5];
            }
        });
        
        for (int i = 0; i < mineralGroup.length; i++) {
            String pick = "";
            
            int tempGroup[] = mineralGroup[i];
            
            if (dia > 0) {
                pick = "diamond";
                dia--;
            } else if (iro > 0) {
                pick = "iron";
                iro--;
            } else if (sto > 0) {
                pick = "stone";
                sto--;
            }
            if(pick.equals(""))
                break;
            
            for(int j =0; j<5; j++)
            {
                if(pick.equals("diamond"))
                {
                    answer += (int) Math.ceil(tempGroup[j] / 25.0);
                }
                else if(pick.equals("iron"))
                {
                    answer += (int) Math.ceil(tempGroup[j] / 5.0);
                }
                else if(pick.equals("stone"))
                {
                    answer += tempGroup[j];
                }
                
                //System.out.println(answer);
                //System.out.println(tempGroup[j]+"\n");
            }

        }
        
        return answer;
    }
}
