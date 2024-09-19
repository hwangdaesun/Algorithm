package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_참외밭 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[][] reqs = new int[6][2];

        for(int i=0; i<reqs.length; i++){
            reqs[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        int maxH = 0;
        int maxW = 0;
        int hIdx = 0;
        int wIdx = 0;

        for(int i=0; i<reqs.length; i++){
            if(reqs[i][0] == 1 || reqs[i][0] == 2){
                if(maxW < reqs[i][1]){
                    maxW = reqs[i][1];
                    wIdx = i;
                }
            }
            if(reqs[i][0] == 3 || reqs[i][0] == 4){
                if(maxH < reqs[i][1]){
                    maxH = reqs[i][1];
                    hIdx = i;
                }
            }
        }


        int w = 0;

        if(hIdx == 0){
            w = Math.abs(reqs[5][1] - reqs[1][1]);
        } else if (hIdx == 5) {
            w = Math.abs(reqs[4][1] - reqs[0][1]);
        }else{
            w = Math.abs(reqs[hIdx + 1][1] - reqs[hIdx - 1][1]);
        }

        int h = 0;

        if(wIdx == 0){
            h = Math.abs(reqs[5][1] - reqs[1][1]);
        } else if (wIdx == 5) {
            h = Math.abs(reqs[4][1] - reqs[0][1]);
        }else{
            h = Math.abs(reqs[wIdx + 1][1] - reqs[wIdx - 1][1]);
        }

        System.out.println((maxH * maxW - h * w) * n);

    }
}
