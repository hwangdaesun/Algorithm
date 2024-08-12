package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2차원배열의합 {

    public static int[][] ans;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nm[0];
        int m = nm[1];
        ans = new int[n][m];

        for(int i=0; i<n; i++){
            int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            ans[i] = x;
        }

        Integer b = Integer.valueOf(br.readLine());
        int sum = 0 ;

        for(int l=0; l<b; l++){
            int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for(int i=req[0]-1; i<=req[2]-1; i++){
                for(int j=req[1]-1; j<=req[3]-1; j++){
                    sum += ans[i][j];
                }
            }
            System.out.println(sum);
            sum = 0;
        }


    }
}
