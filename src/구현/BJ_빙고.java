package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_빙고 {

    static int[][] bgp = new int[5][5];
    static int[] req = new int[25];
    static int count = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            bgp[i][0] = Integer.valueOf(st.nextToken());
            bgp[i][1] = Integer.valueOf(st.nextToken());
            bgp[i][2] = Integer.valueOf(st.nextToken());
            bgp[i][3] = Integer.valueOf(st.nextToken());
            bgp[i][4] = Integer.valueOf(st.nextToken());
        }

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<5; j++){
                req[(i*5) + j] = Integer.valueOf(st.nextToken());
            }
        }

        for(int i=0; i<25; i++){
            mark(i);
            if(i >=10){
                bingoCount();
                if(count >= 3){
                    System.out.println(i+1);
                    break;
                }else{
                    count = 0;
                }
            }

        }


    }

    private static void mark(int i) {
        for(int j=0; j<5; j++){
            for(int m=0; m<5; m++){
                if(bgp[j][m] == req[i]){
                    bgp[j][m] = -1;
                    break;
                }
            }
        }
    }

    private static void bingoCount(){
        for(int i=0; i<5; i++){
            int bg = 0;
            for(int j=0; j<5; j++){
                if(bgp[i][j] == -1) bg++;
            }
            if(bg == 5) count ++;
        }
        for(int i=0; i<5; i++){
            int bg = 0;
            for(int j=0; j<5; j++){
                if(bgp[j][i] == -1) bg++;
            }
            if(bg == 5) count ++;
        }
        if(bgp[0][0] == -1 && bgp[1][1] == -1 &&  bgp[2][2] == -1 && bgp[3][3] == -1 &&  bgp[4][4] == -1){
            count ++;
        }
        if(bgp[0][4] == -1 && bgp[1][3] == -1 &&  bgp[2][2] == -1 && bgp[3][1] == -1 &&  bgp[4][0] == -1){
            count ++;
        }

    }
}
