package 문자열;

import java.io.*;

public class BJ_1543 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String base = br.readLine();

        int n = line.length();
        int bl = base.length();
        int count = 0;

        for(int i=0; i<n; i++){
            if(base.charAt(0) == line.charAt(i)){
                if(i + bl > n){
                    break;
                }
                if(base.equals(line.substring(i, i+bl))){
                    count++;
                    i += (bl-1);
                }
            }
        }

        System.out.println(count);
    }
}
