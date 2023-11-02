package oop;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Scanner;

public class MD5Hashing {
    public static Scanner sc = new Scanner(System.in);
    public static String getMD5(String input){
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
//        byte[] bytes = "ABCDEFG".getBytes();
//        for(byte b : bytes){
//            System.out.print(b + " ");
//        }
//        String password = "password";
//        String encodedPassword = getMD5(password);
//
//        System.out.print("Enter your password: ");
//        String inputPassword = sc.nextLine();
//
//        while (!getMD5(inputPassword).equals(encodedPassword)){
//            System.out.print("Re-enter your password: ");
//            inputPassword = sc.nextLine();
//        }
//        System.out.println("Password is correct!");
    }
}
