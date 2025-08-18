package programmers.hash.revenge;

import java.util.*;

public class 베스트앨범_R5 {
    public int[] solution(String[] genres, int[] plays) {

        List<Integer> answer = new ArrayList<>();

        // 장르별 개수
        Map<String, Integer> genreMap = new HashMap<>();
        // 음악 전체 정보
        Map<String, Map<Integer, Integer>> musicInfo = new HashMap<>();

        for(int i = 0 ; i < genres.length; i ++){
            // 장르
            String genre = genres[i];
            // 플레이 횟수
            Integer play = plays[i];
            // 장르별 플레이 횟 수 init
            genreMap.put(genre , genreMap.getOrDefault(genre,0) + play);

            // 음악 정보 init
            Map<Integer, Integer> playInfo = musicInfo.getOrDefault(genre, new HashMap<>());
            playInfo.put(i, playInfo.getOrDefault(i,0) + play );
            musicInfo.put(genre, playInfo);

        } // for

        // 정렬
        List<String> sortGenreByPlayCount = new ArrayList<>(genreMap.keySet());
        sortGenreByPlayCount.sort(Comparator.comparing(genreMap::get).reversed());

        // 속한 노래가 많이 재생된 장르를 먼저 진행
        for(String genre : sortGenreByPlayCount){

            // 음악 정보
            Map<Integer, Integer> mMap = musicInfo.get(genre);
            List<Integer> musicSort = new ArrayList<>(mMap.keySet());
            musicSort.sort( (a,b)  ->{
                // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
                int comp =  mMap.get(b) - mMap.get(a);
                //  장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
                return comp == 0 ? a-b : comp;
            });

            answer.add(musicSort.get(0));
            if(musicSort.size() > 1) answer.add(musicSort.get(1));
        } //for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
