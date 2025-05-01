package programmers.hash.revenge;

import java.util.*;

public class 베스트앨범_R {
    // goal : 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며,
    //        노래를 수록하는 기준은 다음과 같습니다.
    //- 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    //- 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    //- 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

    // condition :
    public static void main(String[] arg){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        new 베스트앨범_R().solution(genres, plays);
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        int wrapSize = genres.length;

        Map<String, Integer> totalScoreMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> musicInfo = new HashMap<>();
        for(int i = 0 ; i < wrapSize ; i++){
            String genre = genres[i];
            int play     = plays[i];
            if(totalScoreMap.containsKey(genre)){
                int totalCnt = totalScoreMap.get(genre);
                totalScoreMap.put(genre,totalCnt + play );
                musicInfo.get(genre).put(i, play);
            } else {
                totalScoreMap.put(genre, play);
                Map<Integer, Integer> playInfo = new HashMap<>();
                playInfo.put(i, play);
                musicInfo.put(genre, playInfo);
            } // if - else
        }// loop

        // 내림차순 정렬
        List<String> sort = new ArrayList<>(totalScoreMap.keySet());
        Collections.sort(sort, (o1, o2) -> totalScoreMap.get(o2).compareTo(totalScoreMap.get(o1)) );

        for(String key : sort){
            Map<Integer, Integer> info = musicInfo.get(key);
            List<Integer> sortMusic = new ArrayList(info.keySet());
            Collections.sort(sortMusic, (o1, o2) -> info.get(o2).compareTo(info.get(o1)));

            answer.add(sortMusic.get(0));
            // 음악이 한개 이상일 경우 추가
            if(sortMusic.size() > 1) answer.add(sortMusic.get(1));

        }//

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
