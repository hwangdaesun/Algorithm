package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위식연산 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> s = new Stack<>();

        for(Character c : input.toCharArray()){
            if(Character.isDigit(c)){
                s.push(Integer.valueOf(c.toString()));
            }else{
                Character opp = c;
                int a = s.pop();
                int b = s.pop();
                int cal = cal(c, a, b);
                s.push(cal);
            }
        }
        System.out.println(s.pop());
    }

    public static int cal(Character opp, int a, int b) {
        int x = 0;
        if (opp.equals('+')) {
            x = b + a;
            return x;
        } else if (opp.equals('-')) {
            x = b - a;
        } else if (opp.equals('*')) {
            x = b * a;
        } else {
            x = b / a;
        }
        return x;
    }
    }
