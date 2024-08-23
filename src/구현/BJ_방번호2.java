package 구현;

import java.io.*;
import java.util.*;
public class BJ_방번호2 {

    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sets = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
        int[] ans = new int[10];

        for(int i=0; i<sets.length; i++){
            if(sets[i] == 6){
                ans[9] += 1;
            }
            ans[sets[i]] += 1;
        }

        int j = ans[9] - (ans[9] / 2);
        ans[6] = j;
        ans[9] = ans[9] - j;
        int max = 0;
        for(int i=0; i<ans.length; i++){
            if(ans[i] > max){
                max = ans[i];
            }
        }
        System.out.println(max);
    }
}
