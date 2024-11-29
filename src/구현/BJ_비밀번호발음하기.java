package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_비밀번호발음하기 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character> cl = new ArrayList<>();
        cl.add('a');
        cl.add('e');
        cl.add('i');
        cl.add('o');
        cl.add('u');

        while(true){
            String input = br.readLine();
            if(input.equals("end")){
                break;
            }
            int mmCnt = 0;
            int mCnt = 0;
            int jjCnt = 0;


            boolean isAcceptable = true;
            for(int i=0; i<input.length(); i++){
                char charAt = input.charAt(i);
                char before = 0;
                if(i>=1){
                    before = input.charAt(i-1);
                }
                if(cl.contains(charAt)){
                    mCnt++;
                    mmCnt++;
                    jjCnt = 0;
                }else{
                    mmCnt = 0;
                    jjCnt++;
                }
                if(mmCnt >= 3 || jjCnt >= 3){
                    isAcceptable = false;
                    break;
                }
                if(i>=1 && before == charAt){
                    if(!(before == 'e' || before == 'o')){
                        isAcceptable = false;
                        break;
                    }
                }
            }
            if(mCnt == 0){
                isAcceptable = false;
            }


            if(isAcceptable){
                System.out.printf("<%s> %s", input, "is acceptable.\n");
            }else{
                System.out.printf("<%s> %s", input, "is not acceptable.\n");
            }

        }
    }
}
