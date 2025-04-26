package 정렬;

import java.io.*;
import java.util.*;
public class BJ_5648 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer n = Integer.valueOf(st.nextToken());

        List<Long> inputs = new ArrayList();
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            if(st.hasMoreTokens()){
                String token = st.nextToken();
                sb.append(token);
                sb.reverse();
                Long value = Long.valueOf(sb.toString());
                inputs.add(value);
                sb.setLength(0); // StringBuilder 초기화
                n--;
            }else{
                st = new StringTokenizer(br.readLine());
            }
        }

        Collections.sort(inputs);

        for(Long ll : inputs){
            System.out.println(ll);
        }
    }
}
