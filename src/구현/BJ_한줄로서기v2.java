package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_한줄로서기v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] req = new int[n];
        for(int i=0; i<n; i++){
            req[i] = Integer.valueOf(Integer.valueOf(st.nextToken()));
        }

        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(count == req[i]){
                    for(int k=j; k<n; k++){
                        if(ans[k] == 0){
                            ans[k] = i+1;
                            break;
                        }
                    }
                    break;
                }
                if(ans[j] == 0){
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(ans[i] + " ");
        }

        System.out.println(sb);
    }
}
