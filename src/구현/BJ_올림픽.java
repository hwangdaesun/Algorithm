package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_올림픽 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
//        System.out.println(n);
//        System.out.println(k);
        int[][] input = new int[n][3];
        for(int i=0; i<n; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.valueOf(st1.nextToken());
            int b = Integer.valueOf(st1.nextToken());
            int c = Integer.valueOf(st1.nextToken());
            int d = Integer.valueOf(st1.nextToken());
            input[a-1][0] = b;
            input[a-1][1] = c;
            input[a-1][2] = d;
        }

        int max = 0;
        int a1 = input[k-1][0]; //금
        int b1 = input[k-1][1]; //은
        int c1 = input[k-1][2]; //동
        for(int i=0; i<n; i++){
            if(input[i][0] > a1){
                max++;
            }
            if(input[i][0] == a1 && input[i][1] > b1){
                max++;
            }
            if(input[i][0] == a1 && input[i][1] == b1 && input[i][2] > c1){
                max++;
            }
        }
        System.out.println(max + 1);
    }
}
