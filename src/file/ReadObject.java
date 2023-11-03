package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileInputStream fis = new FileInputStream("src/file/object.txt");
        FileInputStream fis = new FileInputStream("src/file/object.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Student> listStudent = new ArrayList<>();

        while (fis.available() > 0){
            Student student = (Student) ois.readObject();
            listStudent.add(student);
            System.out.println(student.toString());
        }

        ois.close();
        fis.close();
    }
}
