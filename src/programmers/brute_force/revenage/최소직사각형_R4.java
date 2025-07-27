package programmers.brute_force.revenage;

public class 최소직사각형_R4 {

    public static void main(String[] args) {
        new 최소직사각형_R4().solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
    }
    public int solution(int[][] sizes) {
        int maxWidth  = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        // 배열을 순회하며 가로 max , 세로 min을 각각 구함
        // 그후 각각의 가로, 세로의 최대 값을  찾아서 곱셈 후 반환

        for(int i = 0; i < sizes.length; i++){
            int mWidth = Math.max(sizes[i][0], sizes[i][1]);
            int mHeight = Math.min(sizes[i][0], sizes[i][1]);

            maxWidth = Math.max(maxWidth, mWidth);
            maxHeight = Math.max(maxHeight, mHeight);
        }// for

        System.out.println(maxWidth * maxHeight);
        return maxWidth * maxHeight;
    }
}
