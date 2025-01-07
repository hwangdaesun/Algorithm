package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_봄버맨 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        int n = Integer.valueOf(st.nextToken());

        char[][] pan = new char[r][c];
        int[][] age = new int[r][c];

        // 초기화
        for(int i=0; i<r; i++){
            String line = br.readLine();
            for(int j=0; j<c; j++){
                pan[i][j] = line.charAt(j);
                if(pan[i][j] == 'O'){
                    age[i][j] = 1;
                }
            }
        }

        int time = 1;
        int[] mi = {1, -1, 0, 0};
        int[] mj = {0, 0, 1, -1};

        while(time++ < n){
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(pan[i][j] == 'O'){
                        age[i][j] += 1;
                    }
                }
            }

            if(time % 2 == 0){
                // age = 0인 폭탄 채우기
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++){
                        if(pan[i][j] == '.'){
                            pan[i][j] = 'O';
                            age[i][j] = 0;
                        }
                    }
                }
            }else{
                // age == 3인 폭탄 터뜨리기
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++){
                        if(age[i][j] == 3){
                            pan[i][j] = '.';
                            age[i][j] = 0;
                            for (int d = 0; d < 4; d++) {
                                int ni = i + mi[d];
                                int nj = j + mj[d];
                                if (ni < 0 || nj < 0 || ni >= r || nj >= c) continue;
                                pan[ni][nj] = '.';

                            }
                        }
                    }

                }

            }
            if(n % 2 == 0){
                break;
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                bw.append(pan[i][j]);
            }
            bw.append('\n');
        }

        bw.flush();

    }
}
