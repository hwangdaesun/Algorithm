package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_색종이2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int r = 0;
        int c = 0;
        int[][] req = new int[100][100];
        for(int k=0; k<n; k++){
            int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            c = rc[0];
            r = rc[1];
            for(int i=r; i<r+10; i++){
                for(int j=c; j<c+10; j++){
                    if(req[i][j] != 1){
                        req[i][j] = 1;
                    }
                }
            }

        }

        int count = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(req[i][j] == 1){
                    count ++;
                }
            }
        }

        System.out.println(count);
    }
}
