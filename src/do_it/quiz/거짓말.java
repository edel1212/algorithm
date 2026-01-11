package do_it.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 파티에 참석하는 인원들을 union 하여 (parent 는 전체 인원으로 함 - 어차피 union 대상이 아니면 합쳐지지 않으니)
// 정답을 아는 사람들과 find 하여 찾는다!
public class 거짓말 {
    public static int[] parent;
    public static int[] truthKnowPersons;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람 수
        int N = Integer.parseInt(st.nextToken());
        // 파티 수
        int M = Integer.parseInt(st.nextToken());

        // 진실을 아는 정보
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        // 진실을 아는 자가 없을 경우
        if(truthCount == 0){
            bw.write(String.valueOf(M));
            bw.flush();
            bw.close();
            return;
        }// if

        // 진실을 아는 자들
        truthKnowPersons = new int[truthCount];
        // 진실을 아는 자 배열
        for(int i = 0 ; i < truthCount; i++){
            truthKnowPersons[i] = Integer.parseInt(st.nextToken());
        } // while

        // parent init (진실을 아는 사람 수가 아닌 전체 사람 수 만큼 해야함)
        parent = new int[N + 1];
        for(int i = 0 ; i <= N ; i++ ){
            parent[i] = i;
        } // for


        // 파티 정보 저장 및 Union 연산 (모든 파티의 참성 인원을 그룹화 하면 연관 관계를 알 수 있음)
        List<Integer>[] parties = new ArrayList[M];
        for(int i = 0 ; i < M ; i++){
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            // 파티 인원
            int partySize = Integer.parseInt(st.nextToken());

            if(partySize == 0) continue;

            int firstPerson = Integer.parseInt(st.nextToken());
            parties[i].add(firstPerson);

            // 파티에 온 사람들을 첫 번째 사람과 모두 union 시킴
            for(int j = 1 ; j < partySize; j++){
                int nextPeron = Integer.parseInt(st.nextToken());
                parties[i].add(nextPeron);
                // 왜 ?? 이건 그럼 합잡합이 첫번째 사람만이랑 연결 되잖아
                union(firstPerson, nextPeron);
            } // for
        } // for

        int count = 0;
        // 파티 수만 큼 Loop ( 파티 참석 인원들만 모아 놓은 배열이 있음 )
        for(int i = 0; i< M ; i++){
            boolean canLie = true;
            for(int attendedPartyPerson : parties[i]){
                // 진실을 아는자가 있는지 확인
                if (isRelatedToTruth(attendedPartyPerson)) {
                    canLie = false;
                    break;
                } // if
            }// for
            // 거짓말이 가능할 경우 ++
            if (canLie) count++;
        } // for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    // 전달 받은 사람이 진실을 아는 사람 엮여 있는 그룹이 있는지 확인
    public static boolean isRelatedToTruth(int person){
        int baseRoot = find(person);
        for(int truthKnowPerson : truthKnowPersons){
            // 진실을 아는자와 엮여 있음
            if(baseRoot == find(truthKnowPerson)) return  true;
        } // for
        return false;
    }


    public  static  void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootB != rootA){
            parent[rootA] = rootB;
        } // if
    }

    public static int find(int i){
        if(i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

}
