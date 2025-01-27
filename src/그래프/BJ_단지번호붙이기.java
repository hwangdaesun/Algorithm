package 그래프;

import java.io.*;
import java.util.*;
public class BJ_단지번호붙이기 {

    static int[][] input;
    static int limit;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        input = new int[n][n];
        limit = n;

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                input[i][j] = Integer.valueOf(String.valueOf(line.charAt(j)));
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(input[i][j] == 1){
                    int bfs = bfs(i, j);
                    ans.add(bfs);
                }
            }
        }


        System.out.println(ans.size());
        ans.stream().sorted().forEach(
                i -> System.out.println(i)
        );
    }

    public static int bfs(int startI, int startJ){
        int cnt = 0;
        input[startI][startJ] = 0;
        Ij ij = new Ij(startI, startJ);
        Queue<Ij> que = new LinkedList<>();
        que.offer(ij);
        cnt++;

        while(!que.isEmpty()){
            Ij cur = que.poll();
            int i =  cur.i;
            int j =  cur.j;

            if(i+1 < input.length){
                if(input[i+1][j] == 1){
                    que.offer(new Ij(i+1, j));
                    input[i+1][j] = 0;
                    cnt++;
                }
            }

            if(i-1 >= 0){
                if(input[i-1][j] == 1){
                    que.offer(new Ij(i-1,j));
                    input[i-1][j] = 0;
                    cnt++;
                }
            }

            if(j+1 < input.length){
                if(input[i][j+1] == 1){
                    que.offer(new Ij(i,j+1));
                    input[i][j+1] = 0;
                    cnt++;
                }
            }

            if(j-1 >= 0){
                if(input[i][j-1] == 1){
                    que.offer(new Ij(i, j-1));
                    input[i][j-1] = 0;
                    cnt++;
                }
            }

        }
        return cnt;
    }

    public static class Ij{
        int i;
        int j;
        Ij(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
