import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue <int []> qin=new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        
        PriorityQueue <int []> qout=new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        int mytime[][] = new int[book_time.length][2];

        for(int i =0; i< book_time.length; i++)
        {
            int starthour = Integer.parseInt(book_time[i][0].substring(0, 2));
            int startmin = Integer.parseInt(book_time[i][0].substring(3, 5));

            int endhour = Integer.parseInt(book_time[i][1].substring(0, 2));
            int endmin = Integer.parseInt(book_time[i][1].substring(3, 5)) +10;

            int start = starthour*100 + startmin;

            if(endmin >=60)
            {
                endmin -=60;
                endhour+=1;
            }

            int end = endhour*100 + endmin;

            mytime[i][0] = start;
            mytime[i][1] = end;
        }
        for(int i =0; i<mytime.length; i++) {
            qin.add(mytime[i]);
        }

        while(!qin.isEmpty()) {
            int[] current = qin.poll();
            
            if(!qout.isEmpty() && qout.peek()[1] <= current[0]) //이미 배정되어있는 것중에 가장 빨리 끝나는 회의실인데, 들어와야 하는 방이 더 시간이 늦을 때 -> 끝나는 방 빼고 넣기
            {
                qout.poll();
                qout.add(current);
            }
            else if(qout.isEmpty()) // 배정되어있는 방이 없을 때는 바로 추가
            {
                qout.add(current);
                answer++;
            }
            else if(!qout.isEmpty() && qout.peek()[1] >= current[0])
            {
                qout.add(current);
                answer++;
            }
        }

        return answer;
    }
    //1410 1420 1500 1640 1820 2120 3 2 0 1 4 5
    //
}