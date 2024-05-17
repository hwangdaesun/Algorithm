package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 봉우리 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[][] pan = new int[n][n];

        for(int i=0;i<n;i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            pan[i] = s;
        }

        int[][] npan = new int[n+2][n+2];

        for(int i=0;i<n+2;i++){
            for(int j=0; j<n+2; j++){
                if(i == 0 || j ==0 || i == n+1 || j == n+1){
                    npan[i][j] = 0;
                }else {
                    npan[i][j] = pan[i-1][j-1];
                }
            }
        }

        int ans = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1; j<n+1; j++){
                if(npan[i][j] > npan[i+1][j] && npan[i][j] > npan[i][j+1] && npan[i][j] > npan[i-1][j] && npan[i][j] > npan[i][j-1]){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
