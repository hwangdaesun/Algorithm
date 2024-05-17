package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일시반장정하기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int[][] input = new int[n][5];
        for(int i=0; i<n; i++){
            int[] m = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            input[i] = m;
        }

        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                for(int k=0; k<5; k++){
                    if(input[i][k] == input[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }



        System.out.println(answer+1);
    }
}
