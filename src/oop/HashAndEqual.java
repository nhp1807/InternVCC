package oop;

import java.util.Objects;

public class HashAndEqual {
    private String field;
    private Person other;

    public HashAndEqual(){

    }

    public HashAndEqual(String field) {
        this.field = field;
    }

    @Override
    public int hashCode(){
        int result = 17;

        result = 31 * result + field.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // So sánh các trường của đối tượng
        HashAndEqual other = (HashAndEqual) obj;
        if(field.equals(other.field)){
            return true;
        }
        return false;
//        return Objects.equals(field, other);
    }

    public static void main(String[] args) {
        HashAndEqual obj1 = new HashAndEqual("Phong");
        HashAndEqual obj2 = new HashAndEqual("Phong");
//        System.out.println(obj1.hashCode());
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.getClass());
        System.out.println(obj2.getClass());
    }
}
