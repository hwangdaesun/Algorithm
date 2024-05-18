package 구현;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_프린터큐 {

    public static int n;
    public static int m;
    public static Queue<int[][]> queue = new LinkedList<>();
    public static int count = 0;
    public static boolean flag = false;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer k = Integer.valueOf(br.readLine());
        for(int l=0; l<k; l++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.valueOf(st.nextToken());
            m = Integer.valueOf(st.nextToken());

            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            queue.clear();
            for(int i=0; i<inputs.length; i++){
                queue.add(new int[][]{{inputs[i],i}});
            }

            flag = false;
            count = 0;

            while(!flag){
                // 최댓값을 정한다.

                int max = queue.peek()[0][0];;
                for(int i=0; i< queue.size(); i++){
                    int[][] next = queue.poll();
                    if(max < next[0][0]){
                        max = next[0][0];
                    }
                    queue.offer(next);
                }

                // 최댓값을 출력
                for(int i=0; i< queue.size(); i++){
                    int[][] next = queue.poll();

                    if(max == next[0][0]){
                        count ++;
                        if(m == next[0][1]){
                            System.out.println(count);
                            flag = true;
                            break;
                        }else{
                            break;
                        }
                    }
                    queue.offer(next);
                }
            }
        }



    }
}
