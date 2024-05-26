package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BJ_교수님저는취업할래요 {

    public static int[][] input;
    public static int limit = 25;

    public static int sLimit = 3;
    public static int[] proX = new int[2];
    // [행,열] 위치 교수
    public static int[] sgX = new int[2];
    // [행,열] 위치 성규

    public static List<int[]> stuX = new ArrayList<>();
    // 일반 학생
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine()); // 행, 열 길이

        input = new int[n][n];




        for(int i=0; i<input.length; i++){
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for(int j=0; j<input[i].length; j++){
                input[i] = array;
                if(input[i][j] == 0){
                    continue;
                }
                if(input[i][j] == 5){
                    // 교수
                    proX[0] = i;
                    proX[1] = j;
                } else if (input[i][j] == 2) {
                    // 성규
                    sgX[0] = i;
                    sgX[1] = j;
                }else if(input[i][j] == 1){
                    // 학생
                    int[] sX = new int[2];
                    sX[0] = i;
                    sX[1] = j;
                    stuX.add(sX);
                }

            }
        }


        int x = proX[0] - sgX[0];
        int y = proX[1] - sgX[1];

        int xy = x*x + y*y;

        if(xy < limit){
            System.out.println(0);
        }else{
            int RR = proX[0] > sgX[0] ? proX[0] : sgX[0];
            int rr = proX[0] < sgX[0] ? proX[0] : sgX[0];
            int CC = proX[1] > sgX[1] ? proX[1] : sgX[1];
            int cc = proX[1] < sgX[1] ? proX[1] : sgX[1];

            int count = 0;
            for(int i=0; i<stuX.size(); i++){
                if(stuX.get(i)[0] >= rr && stuX.get(i)[0] <= RR && stuX.get(i)[1] >= cc && stuX.get(i)[1] <= CC){
                    count++;
                }
            }

            if(count >= sLimit){
                System.out.println(1);
            }else{
                System.out.println(0);
            }

        }
    }
}
