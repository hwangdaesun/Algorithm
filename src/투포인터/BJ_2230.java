package 투포인터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2230 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[] input = new int[n];

        for(int i=0; i<n; i++){
            input[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(input);

        int ans = Integer.MAX_VALUE;

        int j = 0;
        for(int i=0; i<n; i++){
            if((input[j] - input[i]) >= m){
                ans = Math.min(ans, (input[j] - input[i]));
            }else{
                while(true){
                    if(m > (input[j] - input[i])){
                        if(j < n-1){
                            j++;
                        }else{
                            break;
                        }
                    }else{
                        ans = Math.min(ans, (input[j] - input[i]));
                        break;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
