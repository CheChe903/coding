import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int team[] = new int[3];

        int firstTeamScore =0;
        int secondTeamScore = 0;

        int lastSeconds = 0;

        for(int i=0; i<N; i++) {
            st=  new StringTokenizer(br.readLine());

            int scoreTeam = Integer.parseInt(st.nextToken());

            String scoreTime = st.nextToken();

            String[] time = scoreTime.split(":");

            int seconds = Integer.parseInt(time[0]) *60 + Integer.parseInt(time[1]);
        

            if(firstTeamScore > secondTeamScore)
                team[1] += seconds - lastSeconds;
            else if(firstTeamScore < secondTeamScore)
                team[2] += seconds - lastSeconds;

            if(scoreTeam == 1)
                firstTeamScore++;
            else
                secondTeamScore++;
            
            lastSeconds = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
        }

        
        if(firstTeamScore > secondTeamScore)
            team[1] += 48*60 - lastSeconds;
        else if(firstTeamScore < secondTeamScore)
            team[2] += 48*60 - lastSeconds;

        
        for(int i =1; i<=2; i++) {
            String str = String.format("%02d", team[i]/60);
            System.out.print(str+":");
            str = String.format("%02d", team[i]%60);
            System.out.println(str);
        }

    }

}
