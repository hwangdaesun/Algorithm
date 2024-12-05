package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_자리배정 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int c = Integer.valueOf(st.nextToken());
        int r = Integer.valueOf(st.nextToken());
        Integer k = Integer.valueOf(br.readLine());


        int[][] arr = new int[r+1][c+1];
        int curR = 1;
        int curC = 1;
        arr[curR][curC] = 1;

        List<Dir> dirs = new ArrayList<>();
        dirs.add(new Dir(1,0));
        dirs.add(new Dir(0,1));
        dirs.add(new Dir(-1,0));
        dirs.add(new Dir(0,-1));

        int j =0;
        boolean flag = true;
        for(int i=1; i<k; i++){
            flag = false;
            int m=0;

            while (true){

                Dir dir = dirs.get(j%4);
                int nextR = curR + dir.r;
                int nextC = curC + dir.c;

                if(nextC >=1 && nextC <= c && nextR >=1 && nextR <= r && arr[nextR][nextC] != 1){
                        arr[nextR][nextC] = 1;
                        curR = nextR;
                        curC = nextC;
                        flag = true;
                        break;

                }else{
                    j++;
                    m++;
                }

                if(m>=4){
                    break;
                }

            }

            if(!flag){
                break;
            }
        }


        if(!flag){
            System.out.println(0);
        }else {
            System.out.println(curC + " " + curR);
        }

    }

    public static class Dir{
        int r;
        int c;

        public Dir(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void print(int[][] arr){
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

}
