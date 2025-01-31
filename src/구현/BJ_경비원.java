package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_경비원 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer w = Integer.valueOf(st.nextToken());
        Integer h = Integer.valueOf(st.nextToken());

       int[] inputs = new int[2*(w+h)];

        Integer k = Integer.valueOf(br.readLine());
        int start = 0;

        for(int i=0; i<k + 1; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            Integer dir = Integer.valueOf(st1.nextToken());
            Integer n = Integer.valueOf(st1.nextToken());

            switch (dir){
                case 1 :
                    if(i == k ){
                        start = n;
                        break;
                    }
                    inputs[n] = 1;
                    break;
                case 2 :
                    if(i == k ){
                        start = w + h + (w - n);
                        break;
                    }
                    inputs[w + h + (w - n)] = 1;
                    break;
                case 3 :
                    if(i == k ){
                        start = 2 * w + h + (h-n);
                        break;
                    }
                    inputs[2 * w + h + (h-n)] = 1;
                    break;
                case 4 :
                    if(i == k ){
                        start = w + n;
                        break;
                    }
                    inputs[w + n] = 1;
                    break;
            }
        }

        int count = 0;
        int next = start;
        int back = start;
        int[] ans = new int[k];

        int ans1i = 0;
        int ans2i = k-1;
        for(int i=0; i<inputs.length; i++){
            count++;
            if(next + 1 < inputs.length){
                next += 1;
            }else{
                next = 0;
            }

            if(back - 1 >= 0){
                back -= 1;
            }else{
                back = inputs.length - 1;
            }


            if(inputs[next] == 1){
                if(ans[ans1i] == 0){
                    ans[ans1i] = count;
                }else{
                    ans[ans1i] = Math.min(ans[ans1i], count);
                }
                ans1i++;
            }

            if(inputs[back] == 1){
                if(ans[ans2i] == 0){
                    ans[ans2i] = count;
                }else{
                    ans[ans2i] = Math.min(ans[ans2i], count);
                }
                ans2i--;
            }

        }
        int sum = 0;
        for(int i=0; i<ans.length; i++){
            sum += ans[i];
        }
        System.out.println(sum);




    }
}
