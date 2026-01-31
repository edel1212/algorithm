package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 트리_순회 {
    static int[][] tree;
    static BufferedWriter bw;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연결 횟수
        int N = Integer.parseInt(br.readLine());

        // 초기 배열 생성 col의 0번째는 왼쪽, 1번째는 오른쪽
        tree = new int[26][2];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // index 값을 가져옴 [ A의 index 값은 0 ]
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // 자식 노드가 없을 때 left에 -1 저장
            if(left == '.'){
                tree[node][0] = -1;
            }
            // 자식노드가 있을 경우 값 저장
            else {
                tree[node][0] = left - 'A';
            } // if - else

            if(right == '.'){
                tree[node][1] = -1;
            }
            // 자식노드가 있을 경우 값 저장
            else {
                tree[node][1] = right- 'A';
            } // if - else

        } // for

        // 전위 순회 ROOT
        preOrder(0);
        bw.newLine();
        inOrder(0);
        bw.newLine();
        postOrder(0);


        bw.flush();
        bw.close();
        br.close();
    }

    // ✅ 전위 순회 (부모 먼저 확인 후 자식 확인)
    public static void preOrder(int now) throws IOException{
        if(now == -1) return;
        bw.write(String.valueOf((char) (now + 'A')));
        // Left 확인
        preOrder(tree[now][0]);
        // right 확인
        preOrder(tree[now][1]);
    }

    // ✅ 중위 순회 (중간 먼저 확인 후 자식 확인)
    public static void inOrder(int now) throws IOException{
        if(now == -1) return;
        // left 확인
        inOrder(tree[now][0]);
        bw.write(String.valueOf((char) (now + 'A')));
        // right 확인
        inOrder(tree[now][1]);
    }

    // ✅ 후위 순회 (마지막 먼저 확인 후 자식 확인)
    public static void postOrder(int now) throws IOException{
        if(now == -1) return;
        // left 확인
        postOrder(tree[now][0]);
        // right 확인
        postOrder(tree[now][1]);
        bw.write(String.valueOf((char) (now + 'A')));
    }

}
