package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_방번호 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] req = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
        int[] ans = new int[10];
        for(int i=0; i<req.length ; i++){
            if(req[i] == 6){
                ans[9] ++;
            }else{
                ans[req[i]]++;
            }
        }
        int x = ans[9] / 2;
        ans[6] = x;
        ans[9] = ans[9] - x;

        int max = 0;
        for(int j=0; j<ans.length; j++){
            if(ans[j] > max){
                max = ans[j];
            }
        }
        System.out.println(max);
    }

}
