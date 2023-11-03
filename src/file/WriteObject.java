package file;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Student implements Serializable {
    private String nama;
    private int year;
    private String school;

    public Student(){

    }

    public Student(String nama, int year, String school) {
        this.nama = nama;
        this.year = year;
        this.school = school;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nama='" + nama + '\'' +
                ", year=" + year +
                ", school='" + school + '\'' +
                '}';
    }
}

public class WriteObject {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student("Phong", 2002, "HUST");
        Student student2 = new Student("Doan", 2002, "HUST");

        List<Student> listStudent = new ArrayList<>();
        listStudent.add(student1);
        listStudent.add(student2);

//        FileOutputStream fos = new FileOutputStream("src/file/object.txt");
        FileOutputStream fos = new FileOutputStream("src/file/object.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(Student student : listStudent){
            oos.writeObject(student);
        }
        oos.close();
        fos.close();
    }
}
