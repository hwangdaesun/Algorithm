package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_N과M1 {
    static int m;
    static int n;
    static boolean[] isVisited;
    static int[] ans;
    static StringBuilder sb;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        n = input[0];
        m = input[1];

        ans = new int[m];
        isVisited = new boolean[n+1];

        sb = new StringBuilder();
        dfs(0);


        System.out.println(sb.toString());
    }

    public static void dfs(int depth){
        if(depth == m){
            for(int i=0; i<ans.length; i++){
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                ans[depth] = i;
                dfs(depth+1);
                isVisited[i] = false;
            }
        }
    }
}
