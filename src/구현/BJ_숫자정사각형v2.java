package 구현;

import java.io.*;
import java.util.*;

public class BJ_숫자정사각형v2 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer n = Integer.valueOf(st.nextToken());
        Integer m = Integer.valueOf(st.nextToken());

        List<String> input = new ArrayList<>();
        for(int i = 0; i<n; i++){
            input.add(br.readLine());
        }

        int k;

        if(n > m){
            k = m;
        }else {
            k = n;
        }

        for(int l=k-1; l>=0; l--){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(i + l < n && j + l < m){
                        char c = input.get(i).charAt(j);
                        if(c == input.get(i+l).charAt(j+l) && c == input.get(i+l).charAt(j) && c == input.get(i).charAt(j+l)){
                            System.out.println((l+1) * (l+1));
                            return;
                        }
                    }
                }
            }
        }

    }
}
