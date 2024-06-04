package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_색종이 {

    public static int[][] as = new int[101][101];
    public static int ans;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        List<Integer> a = new ArrayList<>();
        for(int i=0; i<n; i++){
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for(int j=0; j<array.length; j++){
                a.add(array[j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int k=a.get(i*2 + 1); k<a.get(i*2 + 1) + 10; k++){
                for(int j=a.get(i*2); j<a.get(i*2) + 10; j++){
                    if(as[k][j] != 1){
                        as[k][j] = 1;
                    }
                }
            }
        }


        for(int i=0; i<as.length; i++){

            for(int j=0; j<as[i].length; j++){
                if(as[i][j] == 1){
                    ans ++;
                }

            }
        }
        System.out.println(ans);
    }
}
