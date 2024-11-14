package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class BJ_반복수열2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int power = Integer.valueOf(st.nextToken());
        List<Integer> ans = new ArrayList<>();
        ans.add(n);

        while(true){
            int next = next(ans.get(ans.size()-1), power);
            if(ans.contains(next)){
                ans.add(next);
                break;
            }else {
                ans.add(next);
            }
        }

        for(int i=0; i<ans.size(); i++){
            if(Objects.equals(ans.get(ans.size()-1),ans.get(i))){
                System.out.println(i);
                break;
            }
        }
    }

    public static int next(int n, int power){
        int sum = 0;
        while(n > 0){
            int k = n % 10;
            sum += Math.pow(k, power);
            n = n / 10;
        }
        return sum;
    }
}
