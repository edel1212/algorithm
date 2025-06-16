package programmers.brute_force.revenage;

public class 최소직사각형_R3 {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for(int[] item : sizes){
            int maxWidth = Math.max(item[0], item[1]);
            int minHeight = Math.min(item[0], item[1]);

            width = Math.max(width, maxWidth);
            height = Math.max(height, minHeight);
        } //for

        return width * height;
    }
}
