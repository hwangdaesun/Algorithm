package 구현;

import java.io.*;
import java.util.*;

public class BJ_유니크v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        int[][] req = new int[n][3];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            int[] input = Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).toArray();
            for(int j=0; j<3; j++){
                req[i][j] = input[j];
            }
        }

        int[] ans = new int[n];

        for(int j=0; j<3; j++){
            for(int i=0; i<n; i++){
                int reward = req[i][j];
                for(int k=0; k<n; k++){
                    if(i == k) continue;
                    if(req[i][j] == req[k][j]){
                        reward = 0;
                        break;
                    }
                }
                ans[i] += reward;
            }
        }

        for(int i=0; i<n; i++){
            System.out.println(ans[i]);
        }

    }
}
