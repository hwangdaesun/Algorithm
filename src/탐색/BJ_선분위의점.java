package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_선분위의점 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[] dots = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            dots[i] = Integer.valueOf(st1.nextToken());
        }

        int[] nDots = Arrays.stream(dots).sorted().toArray();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = n-1;
        for(int j=0; j<m; j++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int l1 = Integer.valueOf(st2.nextToken());
            int l2 = Integer.valueOf(st2.nextToken());

            int[][] k = binarySearch(nDots, start, end, l1);
            int[][] kk = binarySearch(nDots, start, end, l2);
//
//            System.out.println("kk : " + kk[0][1] + ", k : " + k[0][1]);

            if(k[0][0] == 1 && kk[0][0] == 1){
                sb.append(kk[0][1] - k[0][1] + 1);
            } else if (k[0][0] == -1 && kk[0][0] == 1) {
                sb.append(kk[0][1] - k[0][1] + 1);
            } else if (k[0][0] == 1 && kk[0][0] == -1) {
                sb.append(kk[0][1] - k[0][1]);
            }else {
                sb.append(kk[0][1] - k[0][1]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] binarySearch(int[] input, int start, int end, int key){
        int mid = (start + end) / 2;
        if(start > end){
            return new int[][]{{-1,start}};
        }
        if(input[mid] == key){
            return new int[][]{{1,mid}};
        } else if (input[mid] > key) {
            return binarySearch(input, start, mid - 1, key);
        }else{
            return binarySearch(input, mid + 1, end, key);
        }
    }

}
