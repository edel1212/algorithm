package programmers.hash;

import java.util.*;

public class 베스트앨범 {

    // 목적 : 장르별로 가장 많이 재생된 노래를 두곡씩 모아 베스트 앨범 출시
    //      우선 순위
    //      - 속한 노래가 "많이 재생된 장르를 먼저" 수록합니다.
    //      - 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    //      - 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    // 제한 사항 :
    //      - genres[i]는 고유번호가 i인 노래의 장르입니다.
    //      - plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다
    //      - genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
    //      - 장르 종류는 100개 미만입니다.
    //      - 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
    //      - 모든 장르는 재생된 횟수가 다릅니다.
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        베스트앨범 obj = new 베스트앨범();
        System.out.println(Arrays.toString(obj.solution(genres,plays)));
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        // 장르별 총 play 횟수
        Map<String, Integer> totalGenresMap = new HashMap();
        // 장르명, 음악 정보
        Map<String, Map<Integer, Integer>> musicInfoMap = new HashMap<>();

        for(int index = 0; index < genres.length; index++){
            String genre = genres[index];
            Integer play = plays[index];
            if(totalGenresMap.containsKey(genre)){
                // total
                totalGenresMap.put(genre, totalGenresMap.get(genre) + play);

                // music info
                musicInfoMap.get(genre).put( index , play);
            } else {
                // total
                totalGenresMap.put(genre, play);

                // music info
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(index, play);
                musicInfoMap.put(genre, map);
            }// if - else
        }// for

        // 장르의 total play 기준 내림차순 정렬 배열
        List<String> desSortGenres = new ArrayList<>(totalGenresMap.keySet());
        // 내림 차순이기에 o2로 compare
        Collections.sort(desSortGenres, (o1, o2) -> totalGenresMap.get(o2).compareTo(totalGenresMap.get(o1)) );

        // 정렬된 장르 리스트를 순회하며 각 장르별로 노래를 정렬
        for(String key : desSortGenres) {

            Map<Integer, Integer> musicMap = musicInfoMap.get(key);
            List<Integer> sortMusic = new ArrayList(musicMap.keySet());
            // 각 장르의 HashMap에서 키셋(노래 고유 번호)을 가져와 재생 횟수에 따라 내림차순으로 정렬
            Collections.sort(sortMusic, (s1, s2) -> musicMap.get(s2) - (musicMap.get(s1)));

            answer.add(sortMusic.get(0));
            // 음악이 한개 이상일 경우 추가
            if(sortMusic.size() > 1) answer.add(sortMusic.get(1));

        } // loop

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
