import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayCounts = new HashMap<>(); // 각 장르의 총 재생 횟수를 저장할 맵
        HashMap<String, ArrayList<Integer>> genreSongIndices = new HashMap<>(); // 각 장르의 곡 인덱스를 저장할 맵

        // 각 장르의 총 재생 횟수 계산
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            // 해당 장르의 총 재생 횟수 갱신
            genrePlayCounts.put(genre, genrePlayCounts.getOrDefault(genre, 0) + playCount);

            // 해당 장르의 곡 인덱스 리스트를 가져옴
            ArrayList<Integer> songIndices = genreSongIndices.getOrDefault(genre, new ArrayList<>());

            // 곡 인덱스 리스트에 현재 곡 인덱스 추가
            songIndices.add(i);

            // 장르별 곡 인덱스 리스트 갱신
            genreSongIndices.put(genre, songIndices);
        }

        // 장르별 총 재생 횟수를 내림차순으로 정렬
        List<Map.Entry<String, Integer>> sortedGenrePlayCounts = new ArrayList<>(genrePlayCounts.entrySet());
        Collections.sort(sortedGenrePlayCounts, (a, b) -> b.getValue() - a.getValue());

        ArrayList<Integer> answerList = new ArrayList<>();

        // 장르별로 가장 많이 재생된 곡 두 개씩 answerList에 추가
        for (Map.Entry<String, Integer> entry : sortedGenrePlayCounts) {
            String genre = entry.getKey();
            ArrayList<Integer> songIndices = genreSongIndices.get(genre);

            // 해당 장르에 속한 곡이 하나일 경우
            if (songIndices.size() == 1) {
                answerList.add(songIndices.get(0));
            } else { // 해당 장르에 속한 곡이 두 개 이상일 경우
                // 장르 내에서 재생 횟수가 높은 순으로 정렬
                Collections.sort(songIndices, (a, b) -> plays[b] - plays[a]);

                // 장르 내에서 가장 많이 재생된 곡 두 개만 선택하여 answerList에 추가
                for (int i = 0; i < 2; i++) {
                    answerList.add(songIndices.get(i));
                }
            }
        }

        // answer 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
