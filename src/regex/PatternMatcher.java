package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("phong", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("PHONG");

//        if(matcher.find()){
//            System.out.println("Found");
//        }else{
//            System.out.println("Not found");
//        }

        String str1 = "apple";
        String str2 = "banana";
        String str3 = "orange";

        // Regex pattern
        String regex = "^a.*";

        // Check if the strings start with 'a'
        System.out.println(str1 + " starts with 'a': " + str1.matches(regex));
        System.out.println(str2 + " starts with 'a': " + str2.matches(regex));
        System.out.println(str3 + " starts with 'a': " + str3.matches(regex));

//        String[] strTest = { "","1602","1998","NMD98","1998d","nmdse"};
//        // Kiểm tra xem chuỗi có chứa các chữ cái hay không
//        for(String str: strTest){
//            System.out.println("Chuỗi " + str + " có chứa các chữ cái: "+str.matches(".*[a-zA-Z].*"));
//        }
//        System.out.println("____________");
//        // kiểm tra xem chuỗi có chứa các chữ số hay không
//        for(String str: strTest){
//            System.out.println("Chuỗi " + str + " có chứa các chữ số: "+str.matches(".*[0-9].*"));
//        }

        // Test passwords
        String password1 = "Ab1cd123";
        String password2 = "Password";
        String password3 = "P@ssw0rd";

        // Regex pattern
        String passRegex = "[A-Z][0-9].*";

        // Check if the passwords match the pattern
        System.out.println(password1 + " matches the pattern: " + password1.matches(passRegex));
        System.out.println(password2 + " matches the pattern: " + password2.matches(passRegex));
        System.out.println(password3 + " matches the pattern: " + password3.matches(passRegex));
    }
}
