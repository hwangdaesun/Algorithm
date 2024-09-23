package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class BJ_5635 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        String maxName = null;
        LocalDate maxDate = null; // 나이가 가장 적은 사람
        String minName = null;
        LocalDate minDate = null; // 나이가 가장 많은 사람
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            if(i == 0){
                maxName = st.nextToken();
                minName = maxName;
                String dd = st.nextToken();
                String mm = st.nextToken();
                String yy = st.nextToken();
                maxDate = LocalDate.of(Integer.valueOf(yy), Integer.valueOf(mm), Integer.valueOf(dd));
                minDate = maxDate;
            }else{
                String name = st.nextToken();
                String dd = st.nextToken();
                String mm = st.nextToken();
                String yy = st.nextToken();
                LocalDate date = LocalDate.of(Integer.valueOf(yy), Integer.valueOf(mm), Integer.valueOf(dd));
                if(date.isAfter(maxDate)){
                    maxName = name;
                    maxDate = date;
                }
                if(date.isBefore(minDate)){
                    minName = name;
                    minDate = date;
                }
            }
        }
        System.out.println(maxName);
        System.out.println(minName);
    }
}
