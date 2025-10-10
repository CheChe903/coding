import java.util.*;
import java.time.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int answerDiff = Integer.MIN_VALUE;
        String[] music = new String[musicinfos.length];
        
        
        String inputNeoMelody = normalize(m);
        
        System.out.println(inputNeoMelody);
        
        for(int i=0; i<musicinfos.length; i++) {
            
            String[] input = musicinfos[i].split(",");
            String[] beforeTime = input[0].split(":");
            String[] afterTime = input[1].split(":");
            
            String inputMusicMelody = normalize(input[3]);
            LocalTime before = LocalTime.of(Integer.parseInt(beforeTime[0]), Integer.parseInt(beforeTime[1]));
            LocalTime after = LocalTime.of(Integer.parseInt(afterTime[0]), Integer.parseInt(afterTime[1]));
            int diff = (int) Duration.between(before, after).toMinutes();
            
            String melody = "";
            
            int repeat = diff / inputMusicMelody.length();
            
            while(repeat !=0) {
                repeat--;
                melody += inputMusicMelody;
            }
            int remain = diff % inputMusicMelody.length();
            melody += inputMusicMelody.substring(0, remain);
            if(melody.contains(inputNeoMelody)) {
                if(diff > answerDiff) {
                    answer = input[2];
                    answerDiff = diff;
                }
            }
        }
        if(answer.equals("")) {
            return "(None)";
        }
        return answer;
    }
    
    public String normalize(String input) {
        String returnString = "";
        
        for(int i =0; i<input.length()-1; i++) {
            if(input.charAt(i) == '#') continue;
            if(input.charAt(i+1) == '#') {
                returnString += (input.charAt(i) + "").toLowerCase();
            }
            else {
                returnString += input.charAt(i) +"";
            }
        }
        if(input.charAt(input.length()-1) != '#') {
            returnString += input.charAt(input.length()-1) +"";
        }
        return returnString;
    }
}