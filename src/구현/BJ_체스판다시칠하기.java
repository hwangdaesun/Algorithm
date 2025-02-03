package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_체스판다시칠하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.valueOf(st.nextToken());
        int n = Integer.valueOf(st.nextToken());
        int min = Integer.MAX_VALUE;

        boolean[][] input = new boolean[m][n];

        for(int i=0; i<m; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++){
                char charAt = line.charAt(j);
                if(charAt == 'W'){
                    input[i][j] = true;
                }else{
                    input[i][j] = false;
                }
            }
        }

        boolean start;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                int temp = 0;
                start = input[i][j];

                if(i + 7 < m && j + 7 < n){
                    for(int k = 0; k < 8; k++){
                        for(int l = 0; l < 8; l++){

                            if(input[i+k][j+l] != start){
                                temp ++;
                            }
                            start = !start;
                        }
                        start = !start;
                    }

                    temp = Math.min(64 - temp, temp);
                    min = Math.min(temp, min);
                }

            }
        }

        System.out.println(min);

    }
}
