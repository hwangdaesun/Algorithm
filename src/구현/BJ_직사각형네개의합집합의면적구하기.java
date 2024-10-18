package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_직사각형네개의합집합의면적구하기 {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[101][101];
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int c1 = Integer.valueOf(st.nextToken());
            int r1 = Integer.valueOf(st.nextToken());
            int c2 = Integer.valueOf(st.nextToken());
            int r2 = Integer.valueOf(st.nextToken());
            for(int c=c1; c<c2; c++){
                for(int r=r1; r<r2; r++){
                    arr[r][c] = 1;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
