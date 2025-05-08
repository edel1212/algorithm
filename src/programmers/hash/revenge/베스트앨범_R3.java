package programmers.hash.revenge;

import java.util.*;

public class 베스트앨범_R3 {
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500000, 600, 150, 800, 2500};
        new 베스트앨범_R3().solution(genres, plays);
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int wrapSize = genres.length;

        Map<String, Integer> totalCntMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> musicInfo = new HashMap<>();
        for(int i = 0 ; i < wrapSize; i++){
            totalCntMap.put(genres[i], totalCntMap.getOrDefault(genres[i], 0) + plays[i]);

            Map<Integer, Integer> m = musicInfo.getOrDefault(genres[i], new HashMap<>());
            m.put(i, plays[i]);
            musicInfo.put(genres[i], m);
        }// for
        List<String> sortGenresList = new ArrayList<>(totalCntMap.keySet());
        sortGenresList.sort(Comparator.comparingInt(totalCntMap::get).reversed());


        for(String genre : sortGenresList){
            Map<Integer, Integer> mMap = musicInfo.get(genre);
            List<Integer> musicSort = new ArrayList<>(mMap.keySet());
            musicSort.sort( (a,b)  ->{
                int comp =  mMap.get(b) - mMap.get(a);
                return comp == 0 ? a-b : comp;
            });

            answer.add(musicSort.get(0));
            if(musicSort.size() > 1) answer.add(musicSort.get(1));
        } // for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
