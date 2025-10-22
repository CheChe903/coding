class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            int check = 0;
            int currentPersonSchedule = schedules[i];
            int now = startday;
            for(int j =0; j<timelogs[i].length; j++) {
                if(now >=8) {
                    now = 1;
                } 
                if(now >=6) {
                    check+=1;
                    now+=1;
                    continue;
                }
                int currentTimeLog = timelogs[i][j];
                int deadline = addMinutes(currentPersonSchedule, 10);
                if(deadline >= currentTimeLog) {
                    check+=1;
                }
                now+=1;
            }
            if(check == 7) {
                answer+=1;
            }
        }
        
        return answer;
    }
    
        private int addMinutes(int time, int minutes) {
        int hour = time / 100;
        int minute = time % 100;
        
        minute += minutes;
        
        // 60분이 넘으면 시간 올림
        if(minute >= 60) {
            hour += minute / 60;
            minute = minute % 60;
        }
        
        return hour * 100 + minute;
    }
}