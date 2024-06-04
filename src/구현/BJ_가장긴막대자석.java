package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_가장긴막대자석 {

    public static char[] input;

    public static int max = 0;
    public static boolean flag = false;
    public static int cnt = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(br.readLine());
        // 개수

        input = br.readLine().toCharArray();

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(i == 0){
                cnt++;
            }else{
                if(input[i-1] == input[i]) {
                    cnt++;
                }else{
                    max = cnt;
                    System.out.println("max : " + max);
                    cnt = 1;
                    flag = true;
                }
            }
            if(flag){
                ans.add(max);
                flag = !flag;
            }
            if(i == n-1){
                ans.add(cnt);
            }
        }

        int maxL = 0;

        for(int j=1; j<ans.size(); j++){
            int x  = ans.get(j-1) < ans.get(j) ? ans.get(j-1)*2 : ans.get(j)*2;
            maxL = maxL > x ? maxL : x;
        }
        System.out.println(maxL);
    }
}
