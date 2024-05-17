package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 멘토링 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        Integer n = Integer.valueOf(split[0]);
        Integer m = Integer.valueOf(split[1]);

//        System.out.println(n);
//        System.out.println(m);
        int[][] q = new int[m][n];

        for(int i=0;i<m;i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            q[i] = s;
        }

//        for(int i=0;i<m;i++){
//            for(int j=0; j<n; j++){
//                System.out.print(q[i][j] + " ");
//            }
//            System.out.println();
//        }


        int cnt = 0;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                int ia = 0;
                int ja = 0;
                boolean flag = true;
                for(int s=0; s<m; s++){
                    for(int t=0; t<n; t++){
                        if(q[s][t] == i) ia = t;
                        if(q[s][t] == j) ja = t;
                    }
                    if(ia>=ja){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt ++;
            }
        }
        System.out.println(cnt);

    }
}
