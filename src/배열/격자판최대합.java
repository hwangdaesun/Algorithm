package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 격자판최대합 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int pan[][] = new int[n][n];

        for(int i=0;i<n;i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            pan[i] = input;
        }

        int rMax = 0;
        int cMax = 0;

        for(int i=0;i<n;i++){
            int r = 0;
            int c = 0;
            for(int j=0;j<n; j++) {
                r += pan[i][j];
                rMax = Math.max(r, rMax);
                c += pan[j][i];
                cMax = Math.max(c, cMax);
            }
        }


        int xMax = 0;
        int yMax = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n; j++) {
                if(i == j){
                    xMax += pan[i][j];
                }
                if(i + j == n){
                    yMax += pan[i][j];
                }
            }
        }
        int max = Math.max(rMax, cMax);
        int max1 = Math.max(xMax, yMax);
        int max2 = Math.max(max, max1);

        System.out.println(max2);




    }
}
