package oop;

class Student extends Person{
    private String school;

    public Student(){

    }

    public Student(String name, int age, String address, String school){
        super(name, age, address);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }



    @Override
    public String toString(){
        return super.toString() + "\nSchool: " + school;
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Nguyen Hai Phong");
        student.setAge(21);
        student.setAddress("Hanoi");
        student.setSchool("HUST");

        System.out.println(student.toString());

    }
}
