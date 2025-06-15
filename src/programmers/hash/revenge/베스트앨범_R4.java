package programmers.hash.revenge;

import java.util.*;

public class 베스트앨범_R4 {

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 정렬을 위한 Map
       Map<String, Integer> map = new HashMap<>();
        // 음원 횟수 및 index 순서
        Map<String, Map<Integer, Integer>> musicInfo = new HashMap<>();
        // insert
       for(int i = 0 ; i < genres.length ; i++){
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + 1);

            Map<Integer, Integer> m = musicInfo.getOrDefault(genre, new HashMap<>());
            m.put(i, m.getOrDefault(i, 0) + play);
            musicInfo.put(genre, m);

       } //

        // 장르수 만큼 정렬
        List<String> sortGenre = new ArrayList<>(map.keySet());
        sortGenre.sort( Comparator.comparingInt( k -> map.get(k)).reversed() );


        List<Integer> answer = new ArrayList<>();


        for(String genre : sortGenre){

            Map<Integer, Integer> mMap = musicInfo.get(genre);
            List<Integer> musicSort = new ArrayList<>(mMap.keySet());

            musicSort.sort((index1, index2) -> {
                int playCount1 = mMap.get(index1);
                int playCount2 = mMap.get(index2);
                // 재생 수 내림차순
                if (playCount1 != playCount2)  return playCount2 - playCount1;
                // 재생 수가 같으면 인덱스 오름차순
                return index1 - index2;
            });

            answer.add(musicSort.get(0));

            if( musicSort.size()  > 1 ) answer.add(1);

        } // for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
