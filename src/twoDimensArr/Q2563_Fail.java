package twoDimensArr;

import java.io.*;
import java.util.*;

public class Q2563_Fail {
    /**
     * 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 이 도화지 위에 가로,
     * 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
     * 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
     * 색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고,
     * 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 색종이의 수는 100 이하이며,
     * 색종이가 도화지 밖으로 나가는 경우는 없다
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 색종이의 개수
            int paperCnt = Integer.valueOf(br.readLine());

            // 저장될 색종이 넓이 및 위치 값
            List<Map<String, Integer>> tmpArr = new ArrayList<>(paperCnt);

            for(int i = 0 ; i < paperCnt ; i++){
                StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");

                // 도화지 왼쪽 과 색종이 왼쪽 사이 거리
                int xRange = Integer.valueOf(strToken.nextToken());

                // 도화지 아래 과 색종이 아래 사이 거리
                int yRange = Integer.valueOf(strToken.nextToken());

                // 기본 색종이의 넒이 10 * 10
                int area = 100;

                for(Map<String, Integer> item : tmpArr){

                    // X에 포함되는지 체크
                    boolean xChk = item.get("x") <= xRange &&  xRange < item.get("xMax")
                            || item.get("x") <= xRange+10 &&  xRange+10 < item.get("xMax");
                    // y에 포함되는지 체크
                    boolean yChk = (item.get("y") <= yRange &&  xRange < item.get("yMax")
                            || item.get("y") <= yRange+10 &&  xRange+10 < item.get("yMax"));

                    // 겹치는 부분이 있을 경우
                    if( xChk && yChk ){
                        // 가로 길이 값
                        int with = 0;
                        if(xRange > item.get("x")){
                            with = item.get("xMax") - xRange;
                        } else{
                            with = xRange + 10 - item.get("x");
                        }
                        // 높이
                        int height = 0;
                        if(xRange > item.get("y")){
                            height = item.get("yMax") - yRange;
                        } else{
                            height = yRange + 10 - item.get("y");
                        }
                        area -= with * height;
                    } //if
                }//for
                // 색종이 정보
                Map<String, Integer> paperInfo = new HashMap();
                paperInfo.put("x"       , xRange);
                paperInfo.put("xMax"    , xRange + 10);
                paperInfo.put("y"       , yRange);
                paperInfo.put("yMax"    , yRange + 10);
                paperInfo.put("area"    , area);
                tmpArr.add(paperInfo);
            }//for

            bw.write(String.valueOf(tmpArr.stream().map(paper->paper.get("area")).reduce((i,o)->i+o).get()));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
