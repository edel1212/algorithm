package programmers.brute_force;

public class 피로도 {
    /**
     *
     *  던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
     *  - "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
     *  - "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다
     *  한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
     *  - 유저의 현재 피로도 k
     *  - 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수
     *  = 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수
     *
     *  condition : k는 1 이상 5,000 이하인 자연수입니다.
     * - dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
     * - dungeons의 가로(열) 길이는 2 입니다.
     * - dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"]
     * - "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
     * - "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
     * - 서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
     * */

    // 결과
    public int answer = 0;
    // 방문 여부
    public boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        // 방문 여부를 저장할 배열 선언
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int depth, int k, int[][] dungeons){

        // 배열의 크기만큼 반복
        for(int i = 0; i < dungeons.length; i ++){
            // 방문X and 던전의 최소 피로가 현재 피로도에 던전 입장 가능할 경우 ( k가 크거나 같음 )
            if( !visited[i] && dungeons[i][0] <= k ){
                visited[i] = true; // 방문처리
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false; // 방문 초기화
            } //if
        }// for

        answer = Math.max(answer, depth);
    }

}
