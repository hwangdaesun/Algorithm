package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유효한팰린드롬 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split("");

        String alpha = "";

        for(int i=0; i<split.length; i++){
            if(Character.isLetter(split[i].charAt(0))){
                alpha += split[i];
            }
        }

        alpha = alpha.toLowerCase();
        String realpha = new StringBuilder(alpha).reverse().toString();

        if(realpha.equals(alpha)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
