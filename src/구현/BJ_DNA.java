package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_DNA {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer n = Integer.valueOf(st.nextToken());
        Integer m = Integer.valueOf(st.nextToken());
        char[][] input = new char[n][m];
        int sum = 0;

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                input[i][j] = line.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            Map<Character, Integer> maps = new HashMap<>();
            for(int j=0; j<n; j++){
                Integer orDefault = maps.getOrDefault(input[j][i], 0);
                if(orDefault == 0){
                    maps.put(input[j][i], 1);
                }else{
                    maps.put(input[j][i], orDefault + 1);
                }
            }

            char maxC = '0';
            int max = 0;
            for(Character c : maps.keySet()){
                if(max < maps.get(c)){
                    maxC = c;
                    max = maps.get(c);
                }
                if(max == maps.get(c)){
                    if(maxC > c){
                        maxC = c;
                    }
                }
            }

            for(Character c : maps.keySet()){
                if(maxC != c){
                    sum += maps.get(c);
                }
            }

            String s = String.valueOf(maxC);
            sb.append(s);
            maps.clear();
        }

        System.out.println(sb);
        System.out.println(sum);

    }
}
