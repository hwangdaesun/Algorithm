package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_올림픽v2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer n = Integer.valueOf(st.nextToken());
        Integer m = Integer.valueOf(st.nextToken());

        int[][] inputs = new int[n][4];
        int gold = 0;
        int silver = 0;
        int dong = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            int[] kk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            inputs[i] = kk;
            if(m == kk[0]){
                gold = kk[1];
                silver = kk[2];
                dong = kk[3];
            }
        }

//        System.out.println(gold);
//        System.out.println(silver);
//        System.out.println(dong);

        for(int i=0; i<n; i++){
            int gg = inputs[i][1];
            int ss = inputs[i][2];
            int dd = inputs[i][3];
            if(gg > gold || (gg == gold && ss > silver) || (gg == gold && ss == silver && dd > dong)){
                count++;
            }
        }

        System.out.println(count + 1);

    }
}
