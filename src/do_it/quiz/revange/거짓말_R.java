package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 거짓말_R {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람의 수
        int N = Integer.parseInt(st.nextToken());
        // 파티의 수
        int M = Integer.parseInt(st.nextToken());

        // parent init
        parent = new int[N + 1];
        for(int i = 0 ; i <= N ; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        // 진실을 아는자 수
        int tureKnownCount = Integer.parseInt(st.nextToken());

        // 진실이 아는 자가 0 명일 경우 파티 개수 바로 반환
        if(tureKnownCount == 0) {
            bw.write(String.valueOf(M));
            bw.flush();
            bw.close();
            System.exit(0);
        } // if

        // 진실을 아는 자를 저장한 배열
        int[] tureKnowPeoples = new int[tureKnownCount];
        for(int i = 0 ; i < tureKnownCount ; i++){
            tureKnowPeoples[i] = Integer.parseInt(st.nextToken());
        } // for

        // 파티 정보
        List<Integer> parties = new ArrayList<>();

        // 각가의 파티를 순회하며 만났던 사람들을 union 시켜줌
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            // 파티의 인원 수
            int p = Integer.parseInt(st.nextToken());
            // 기준이 될 사람 (한 파티에 만나면 어차피 다 만나는 것이기 떄문에 대표를 두고 진행)
            int basePeople = Integer.parseInt(st.nextToken());
            // 파티의 대표 저장
            parties.add(basePeople);
            for(int j = 1 ; j < p ; j++){
                // 다음 대상
                int nextPeople = Integer.parseInt(st.nextToken());
                // 파티정보 저장
                // 조합
                union(basePeople,  nextPeople);
            } // for
        }// for

        // 거짓말을 할 수 있는 파티 수
        int result = 0;
        for(int boss : parties){

            // 해당 파티에서 거짓말 가능 여부
            boolean canLie = true;

            // 진실을 아는자와 비교
            for(int truePeople : tureKnowPeoples){

                // 파티의 대표가 진실을 아는자와 같은 그룹일 경우 skip
                if( find(boss) == find(truePeople) ){
                    // 진실을 아는자가 있으므로 거짓말 불가능
                    canLie = false;
                    break;
                } // if
            } // for
            // 거짓말을 할 수 있으므로 ++
            if(canLie) result++;
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }


    private static int find(int x){
        if( parent[x] == x ) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if( rootA == rootB ) return false;

        parent[rootA] = rootB;
        return true;
    }
}
