import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        int answer = 0;
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(isSimilar(words[i], words[j])) {
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
    
    private static boolean isSimilar(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        
        // 각 문자의 매핑 관계를 저장
        Map<Character, Character> map = new HashMap<>();
        // 이미 매핑된 대상 문자를 체크
        Set<Character> used = new HashSet<>();
        
        for(int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            
            // 이미 매핑된 문자인 경우
            if(map.containsKey(c1)) {
                if(map.get(c1) != c2) return false;
            } else {
                // 새로운 매핑을 만드는 경우
                if(used.contains(c2)) return false;  // 이미 다른 문자와 매핑된 경우
                map.put(c1, c2);
                used.add(c2);
            }
        }
        
        return true;
    }
}