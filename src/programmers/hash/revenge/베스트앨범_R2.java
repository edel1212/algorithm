package programmers.hash.revenge;

import java.util.*;

public class 베스트앨범_R2 {
    // goal : 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시
    //      - 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    //      - 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    //      - 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500000, 600, 150, 800, 2500};
        new 베스트앨범_R2().solution(genres, plays);
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int wrapSize = genres.length;
        Map<String, Integer> totalPalyMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> playInfo = new HashMap<>();
        for(int i = 0; i < wrapSize ; i++ ){
            if(totalPalyMap.containsKey(genres[i])){
                totalPalyMap.put( genres[i], totalPalyMap.get(genres[i]) + plays[i] );
            } else{
                totalPalyMap.put(genres[i], plays[i]);
            } // if - else

            Map<Integer, Integer> map = playInfo.getOrDefault(genres[i], new HashMap<>());
            map.put(i, plays[i]);  // 인덱스를 key로, 재생 수를 value로 저장
            playInfo.put(genres[i], map);
        }//


        List<String> sortGenres = new ArrayList<>(totalPalyMap.keySet());
        sortGenres.sort( (i,j)-> totalPalyMap.get(j).compareTo(totalPalyMap.get(i)) );

        for(String genre : sortGenres){

            Map<Integer, Integer> playInfoByGenreMap = playInfo.get(genre);
            List<Integer> descListen = new ArrayList<>(playInfoByGenreMap.keySet());
            Collections.sort( descListen, (i, j) -> playInfoByGenreMap.get(j).compareTo(playInfoByGenreMap.get(i)) );

            Collections.sort(descListen, (i, j) -> {
                int comp = playInfoByGenreMap.get(j).compareTo(playInfoByGenreMap.get(i));
                if (comp == 0) return Integer.compare(i, j); // 재생 수 같으면 고유번호 오름차순
                return comp;
            });


            answer.add(descListen.get(0));

            if(descListen.size() > 1) answer.add(descListen.get(1));

        } // loop


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
