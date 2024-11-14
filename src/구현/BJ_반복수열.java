package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ_반복수열 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        List<Integer> ans = new ArrayList<>();
        String n = st.nextToken();
        ans.add(Integer.valueOf(n));
        int pow = Integer.parseInt(st.nextToken());

        int idx = 0;
        while(true){
            int[] d = calSol(ans.get(idx));
            idx ++;
            int next = 0;
            for(int i=0; i<d.length; i++){
                next += Math.pow(d[i], pow);
            }
            ans.add(next);

            if(ans.size() != ans.stream().collect(Collectors.toSet()).size()){
                break;
            }
        }
        int limit = ans.get(ans.size()-1);
        int real = 0;
        for(int i=0; i<ans.size(); i++){
            if(ans.get(i) == limit){
                real = i;
                break;
            }
        }
        System.out.println(real);
    }

    private static int[] calSol(int n) {
        int length = String.valueOf(n).length();
        int key = n;
        int[] sol = new int[length];

        while(length > 0){
            sol[length-1] = key / ((int)Math.pow(10,length-1));
            key = key % ((int)Math.pow(10,length-1));
            length --;
        }
        return sol;
    }
}
