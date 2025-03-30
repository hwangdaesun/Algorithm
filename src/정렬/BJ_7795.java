package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_7795 {
    static int t;
    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Integer as = Integer.valueOf(st.nextToken());
            Integer bs = Integer.valueOf(st.nextToken());

            int[] aa = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] bb = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

            Arrays.sort(aa);
            Arrays.sort(bb);

            int count = 0;
            int temp = 0;

            int j = 0;
            for(int k=0; k<as; k++){
                if(j == bs){
                    count += temp;
                    continue;
                }
                while(aa[k] > bb[j] && j < bs){
                 j++;
                 temp ++;
                 if(j == bs) break;
                }
                count += temp;
            }
            sb.append(count + "\n");
        }
        System.out.println(sb.toString());
    }
}
