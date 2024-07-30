package 구현;;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_덱 {

    static Deque<Integer> dec = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        for(int i=0; i<n; i++){
            String command = br.readLine();
            execute(command);
        }

    }

    public static void execute(String command){
        String[] s = command.split(" ");
        if(s.length == 2){
            if(s[0].equals("push_back")){
                dec.offerLast(Integer.valueOf(s[1]));
            }else{
                dec.offerFirst(Integer.valueOf(s[1]));
            }
        }else{
            Integer n = null;
            switch (command){
                case "pop_front" :
                    n = dec.pollFirst();
                    if (n == null) {
                        System.out.println("-1");
                    } else {
                        System.out.println(n);
                    }
                    break;
                case "pop_back" :
                    n = dec.pollLast();
                    if (n == null) {
                        System.out.println("-1");
                    } else {
                        System.out.println(n);
                    }
                    break;
                case "size" :
                    System.out.println(dec.size());
                    break;
                case "empty" :
                    if(dec.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;
                case "front" :
                    n  =  dec.peekFirst();
                    if (n == null) {
                        System.out.println("-1");
                    } else {
                        System.out.println(n);
                    }
                    break;
                case "back" :
                    n  =  dec.peekLast();
                    if (n == null) {
                        System.out.println("-1");
                    } else {
                        System.out.println(n);
                    }
                    break;
            }
        }
    }

}
