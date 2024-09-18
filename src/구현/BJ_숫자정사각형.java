package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_숫자정사각형 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nm[0];
        int m = nm[1];
        int limit = n < m ? n : m;

        int[][] reqs = new int[n][m];
        for(int i=0; i<n; i++){
            reqs[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
        }

        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                    for(int k = limit-1; k>0; k--){
                        if(i+k < n && j+k < m){
                            if(reqs[i][j] == reqs[i][j+k] && reqs[i][j] == reqs[i+k][j] && reqs[i][j] == reqs[i+k][j+k]){
                                max = Math.max(max, k);
                            }
                        }
                    }
                }
        }
        System.out.println((int)Math.pow(max+1,2));
    }
}
