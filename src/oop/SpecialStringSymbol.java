package oop;

public class SpecialStringSymbol {
    public static void main(String[] args) {
        Student student = new Student("Hai Phong", 21, "Hanoi", "HUST");

        // Using %s %d\n
        String formatedString = String.format("Name: %s\nAge: %d", student.getName(), student.getAge());
//        System.out.println(formatedString);

        // Using \t
//        System.out.println("\t" + student.getName());

        // Using \r
//        System.out.print("Hello Happy \rWorld");
    }
}
