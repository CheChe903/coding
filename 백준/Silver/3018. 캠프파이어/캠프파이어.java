import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        
        HashSet<Integer>[] songs = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) {
            songs[i] = new HashSet<>();
        }
        
        int totalSongs = 0;
        
        for (int day = 1; day <= E; day++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            
            boolean seonyoungPresent = false;
            ArrayList<Integer> people = new ArrayList<>();
            
            for (int j = 0; j < k; j++) {
                int person = Integer.parseInt(st.nextToken());
                if (person == 1) seonyoungPresent = true;
                people.add(person);
            }
            
            if (seonyoungPresent) {
                totalSongs++;
                for (int person : people) {
                    songs[person].add(day);
                }
            } else {
                HashSet<Integer> allSongs = new HashSet<>();
                for (int person : people) {
                    allSongs.addAll(songs[person]);
                }
                for (int person : people) {
                    songs[person].addAll(allSongs);
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (songs[i].size() == totalSongs) {
                result.add(i);
            }
        }
        
        for (int person : result) {
            System.out.println(person);
        }
    }
}