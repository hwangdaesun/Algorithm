package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_사탕게임 {
    static Integer n;
    static char[][] reqs;
    static int max = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        reqs = new char[n][n];
        for(int i=0; i<n; i++){
            reqs[i] = br.readLine().toCharArray();
        }

        // 가로로 바꾸기
        for(int i = 0; i<n; i++){
            for(int j=0; j<n-1; j++){
                    char temp;
                    temp = reqs[i][j];
                    reqs[i][j] = reqs[i][j+1];
                    reqs[i][j +1] = temp;
                    max = Math.max(search(), max);
                    temp = reqs[i][j];
                    reqs[i][j] = reqs[i][j+1];
                    reqs[i][j +1] = temp;
                }
            }

        // 세로로 바꾸기
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n; j++){
                char temp;
                temp = reqs[i][j];
                reqs[i][j] = reqs[i+1][j];
                reqs[i+1][j] = temp;
                max = Math.max(search(), max);
                temp = reqs[i][j];
                reqs[i][j] = reqs[i+1][j];
                reqs[i+1][j] = temp;
            }
        }

        System.out.println(max);
    }

    public static int search(){
        int count = 1;
        int max = 1;

        // 행검사
        for(int i = 0; i<n; i++){
            count = 1;
            for(int j=0; j<n-1; j++){
                if(reqs[i][j] == reqs[i][j+1]){
                    count ++;
                    max = Math.max(count,max);
                }else{
                    count = 1;
                }
            }
        }

        // 열검사
        for(int i = 0; i<n; i++){
            count = 1;
            for(int j=0; j<n-1; j++){
                if(reqs[j][i] == reqs[j+1][i]){
                    count ++;
                    max = Math.max(count,max);
                }else{
                    count = 1;
                }
            }
        }
        return max;
    }
}
