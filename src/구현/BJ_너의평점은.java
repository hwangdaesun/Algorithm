package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_너의평점은 {

    public static double sumOfRecord = 0;
    public static double sumOfGrade = 0;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i< 20; i++){
            String s = br.readLine();
            String[] s1 = s.split(" ");
            if(!s1[2].equals("P")){
                sumOfRecord += Double.valueOf(s1[1]);
                sumOfGrade += Double.valueOf(getGrade(s1[2])) * Double.valueOf(s1[1]);
            }
        }
        System.out.println(Math.round((sumOfGrade/sumOfRecord) * 1000000) / 1000000.0);
    }

    private static double getGrade(String s) {
        double grade = 0;
        switch (s){
            case "A+":
                grade = 4.5;
                break;
            case "A0":
                grade = 4.0;
            break;
            case "B+":
                grade = 3.5;
            break;
            case "B0":
                grade = 3.0;
            break;
            case "C+":
                grade = 2.5;
            break;
            case "C0":
                grade = 2.0;
            break;
            case "D+":
                grade = 1.5;
            break;
            case "D0":
                grade = 1.0;
            break;
            case "F":
                grade = 0.0;
            break;
        }
        return grade;
    }

}
