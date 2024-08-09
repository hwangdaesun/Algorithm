package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_집합 {

    public static int ans = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            String[] s1 = s.split(" ");
            String command = null;
            Integer x = null;
            if(s1.length == 2) {
                command = s1[0];
                x = Integer.valueOf(s1[1]);
            }else {
                command = s1[0];
            }
            switch (command){
                case "add" :
                    ans |= (1 << x);
                    break;
                case "remove" :
                    ans &= ~(1 << x);
                    break;
                case "check":
                    stringBuilder.append((ans & (1 << x)) != 0 ? 1: 0);
                    stringBuilder.append('\n');
                    break;
                case "toggle":
                    ans ^= (1 << x);
                    break;
                case "all":
                    ans |= (1 << 21) - 1;
                    break;
                case "empty":
                    ans = 0;
                    break;
            }
        }
        System.out.println(stringBuilder);
    }

}
