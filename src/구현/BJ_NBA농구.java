package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_NBA농구 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int score1 = 0;
        int score2 = 0;
        int time1 = 0;
        int time2 = 0;
        int allTime = 48 * 60;
        int prevTime = 0;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Integer team = Integer.valueOf(st.nextToken());
            String[] split = st.nextToken().split(":");
            int time = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);

            int restTime = time - prevTime;
            prevTime = time;

            if (score1 > score2){
                time1 += restTime;
            }
            if (score1 < score2){
                time2 += restTime;
            }

            if(team == 1){
                score1++;
            }else {
                score2++;
            }

            if(i == n-1){

                restTime = allTime - time;
                if (score1 > score2){
                    time1 += restTime;
                }
                if (score1 < score2){
                    time2 += restTime;
                }

            }

        }
        int hour1 = 0;
        int sec1 = 0;

        if(time1 != 0){
            hour1 = time1 / 60;
            sec1 = time1 - hour1 * 60;
        }
        System.out.println(String.format("%02d:%02d", hour1, sec1));

        int hour2 = 0;
        int sec2 = 0;

        if(time2 != 0){
            hour2 = time2 / 60;
            sec2 = time2 - hour2 * 60;
        }

        System.out.println(String.format("%02d:%02d", hour2, sec2));
    }
}
