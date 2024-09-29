package 구현;

import java.io.*;
import java.util.*;
public class BJ_구간합구하기5 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[][] req = new int[m][4];
        int[][] box = new int[n][n];
        int[][] sum = new int[n][n];

        for(int i=0; i<n; i++){
            box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        for(int i=0; i<m; i++){
            req[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }


        int before = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum[i][j] = before + box[i][j];
                before = sum[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int r1 = req[i][0]-1;
            int c1 = req[i][1]-1;
            int r2 = req[i][2]-1;
            int c2 = req[i][3]-1;
            int tmp = 0;
            for(int j=r1; j<=r2; j++){
                tmp += (sum[j][c2] - sum[j][c1] + box[j][c1]);
            }
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}
