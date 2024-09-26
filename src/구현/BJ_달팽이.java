package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_달팽이 {

    static int[][] req;
    static int[] dir = {1,2,3,4};
    static int dIdx = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        req = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                req[i][j] = -1;
            }
        }

        Integer k = Integer.valueOf(br.readLine());

        int r = 0;
        int c = 0;
        int ar = 0;
        int ac = 0;


        for(int i = n*n; i>0; i--){
            if(i == n*n){
                req[r][c] = i;
                continue;
            }
            // 방향의 전환 필요
            // dIdx에 따라 이동 후 해당 공간이 값이 -1이 아니거나 제한된 공간이라면 dIdx ++
//            System.out.println("dIdx % 4 : " + dIdx % 4);
            int choice = dir[dIdx % 4];
            int rTmp = r;
            int cTmp = c;
            switch (choice){
                case 1:
                    rTmp++;
                    break;
                case 2:
                    cTmp++;
                    break;
                case 3:
                    rTmp--;
                    break;
                case 4:
                    cTmp--;
                    break;
            }
//            System.out.println("rTmp, cTmp : " + rTmp + " " +cTmp);
            if(!(rTmp > -1 && rTmp < n && cTmp > -1 && cTmp < n) || req[rTmp][cTmp] != -1) dIdx++;
            int real = dir[dIdx % 4];
//            System.out.println("dIdx : " + dIdx);
//            System.out.println("real : " + real);
//            System.out.println("i : " + i);
            switch (real){
                case 1:
                    req[++r][c] = i;
                    break;
                case 2:
                    req[r][++c] = i;
                    break;
                case 3:
                    req[--r][c] = i;
                    break;
                case 4:
                    req[r][--c] = i;
                    break;
            }
            if(i == k){
                ar = r + 1;
                ac = c + 1;
            }
            if(ar == 0 && ac == 0){
                ar = 1;
                ac = 1;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(req[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print(ar + " " + ac);
    }
}
