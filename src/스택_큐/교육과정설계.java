package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정설계 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split("");
        Queue<String> aq = new LinkedList<>();
        for(String x : a){
            aq.offer(x);
        }

        String[] b = br.readLine().split("");
        Queue<String> bq = new LinkedList<>();
        for(String x : b){
            bq.offer(x);
        }

        int z = bq.size();

        for(int i=0; i<z; i++){
            if(aq.isEmpty()){
                break;
            }else{
                String k = aq.peek();
                if(k.equals(bq.poll())){
                    aq.poll();
                }
            }
        }


        if(aq.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
