package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_교수님저는취업할래요2 {

    static int N;
    static int[] first = new int[2];
    static int[] second = new int[2];
    static int [][] req;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        req = new int[N][N];

        for(int i=0; i<N; i++){
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            req[i] = array;
        }

        int aa = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(req[i][j] == 5 || req[i][j] == 2){
                    aa ++;
                    if(aa == 1){
                        first[0] = i;
                        first[1] = j;
                    } else if (aa == 2) {
                        second[0] = i;
                        second[1] = j;
                    }else{
                        break;
                    }
                }
            }
        }

        int l = first[0] - second[0];
        int m = first[1] - second[1];

        double sqrt = Math.sqrt(l * l + m * m);

        // 행과열이 같을 경우
        if(first[0] == second[0]){
            int count = 0;
            for(int i= first[1]; i<second[1]; i++){
                if(req[first[0]][i] == 1){
                    count ++;
                }
            }
            if(count >= 3 && sqrt >= 5) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        } else if (first[1] == second[1]) {
            int count = 0;
            for(int i= first[0]; i<second[0]; i++){
                if(req[i][first[1]] == 1){
                    count ++;
                }
            }
            if(count >= 3 && sqrt >= 5) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }else{
            int count = 0;
            int s = first[1] > second[1]? second[1]: first[1];
            int b = first[1] > second[1]? first[1]: second[1];
            for(int j=first[0]; j<= second[0]; j++){
                for(int i=s; i<=b; i++){
                    if(req[j][i] == 1){
                        count ++;
                    }
                }
            }
            if(count >= 3 && sqrt >= 5) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}
