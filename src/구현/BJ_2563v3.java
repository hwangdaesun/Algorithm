package 구현;

import java.io.*;
import java.util.*;

public class BJ_2563v3 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int[][] xx = new int[101][101];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] jk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

            int j = jk[0];
            int k = jk[1];

            for(int l =j; l<j+10; l++){
                for(int m=k; m<k+10; m++){
                    xx[l][m] = 1;
                }
            }
        }

        for(int l =0; l<101; l++){
            for(int m=0; m<101; m++){
                if(xx[l][m] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
