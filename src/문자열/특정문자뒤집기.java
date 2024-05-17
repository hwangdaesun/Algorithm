package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 특정문자뒤집기 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int length = line.length(); // 전체 길이

        int lt = 0;
        int rt = length - 1;
        char[] crs = line.toCharArray();

        while(lt < rt){
            if(!Character.isAlphabetic(crs[lt])) lt++;
            else if (!Character.isAlphabetic(crs[rt])) rt--;
            else{
                char tmp = crs[rt];
                crs[rt] = crs[lt];
                crs[lt] = tmp;
                lt++;
                rt--;
            }
        }

        String line1 = String.valueOf(crs);
        System.out.println(line1);


    }

    // todo : 해설을 참조해야할 듯
}
