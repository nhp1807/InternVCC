package oop;

import java.util.StringTokenizer;

public class StringExercise {
    public static void main(String[] args) {
        // Init new string in many ways
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String s1 = new String(charArray);
        String s2 = new String("Hello");
        String s3 = "Hello";

        // Cut string
        String cutString1 = s1.substring(2);
        String cutString2 = s1.substring(2,4);

        //Merge string
        String mergeString = s1.concat(s2);

//        System.out.println("s1: " + s1);
//        System.out.println("s2: " + s2);
//        System.out.println("s3: " + s3);
//
//        System.out.println("Cut string1: " + cutString1);
//        System.out.println("Cut string2: " + cutString2);
//
//        System.out.println(mergeString);

        // Init StringBuilder
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(20);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Hello");

//        System.out.println(sb1);
//        System.out.println(sb2.capacity());
//        System.out.println(sb3);;

        // Init StringTokenizer
        StringTokenizer st1 = new StringTokenizer("Nguyen, Hai, Phong");
        StringTokenizer st2 = new StringTokenizer("Nguyen, Hai, Phong", ",");
        StringTokenizer st3 = new StringTokenizer("Nguyen, Hai, Phong", ",", false);
        StringTokenizer st4 = new StringTokenizer("Nguyen, Hai, Phong", ",", true);

//        while (st1.hasMoreTokens()){
//            System.out.print(st1.nextToken());
//        }
//        System.out.println();
//        while (st2.hasMoreTokens()){
//            System.out.print(st2.nextToken());
//        }
//        System.out.println();
//        while (st3.hasMoreTokens()){
//            System.out.print(st3.nextToken());
//        }
//        System.out.println();
//        while (st4.hasMoreTokens()){
//            System.out.print(st4.nextToken());
//        }
//        System.out.println();

        StringTokenizer st = new StringTokenizer("Toi-ten-,la-VietTut", "-,", false);
        System.out.println("Tổng số token: " + st.countTokens());
//        while (st.hasMoreTokens()) {
//            System.out.println(st.nextToken());
//        }

        System.out.println("Chuỗi token: " + st.nextToken("-,"));
        System.out.println("Chuỗi token kế tiếp: " + st.nextToken("e"));
        System.out.println("Chuỗi token kế tiếp: " + st.nextToken("a"));
        System.out.println("Chuỗi token kế tiếp: " + st.nextToken("e"));
    }
}
