package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_유니크2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int[][] req = new int[3][n];

        for(int i =0; i<n; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for(int j=0; j<3; j++){
                req[j][i] = input[j];
            }
        }

        int[] score = new int[n];

        for(int k=0; k<3; k++){
            for(int m=0; m<n; m++){
                int now = req[k][m];
                boolean flag = true;
                for(int l=0; l<n; l++){
                    if(now == req[k][l] && m != l){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    score[m] += now;
                }
            }
        }

        for(int i=0; i<score.length; i++){
            System.out.println(score[i]);
        }


    }
}
