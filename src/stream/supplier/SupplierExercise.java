package stream.supplier;

import java.util.function.*;

class Programing{
    public String language;
    public int experience;

    public Programing(){
        this.language = "Java";
        this.experience = 10;
    }

    public void print(){
        System.out.println("Language: " + language + " Experience: " + experience);
    }

    public static String getDefaultLangue(){
        return "Java";
    }
}

class NumberUtils {

    public static boolean getBooleanValue() {
        return true;
    }

    public static int getIntValue() {
        return 1;
    }

    public static long getLongValue() {
        return 2;
    }

    public static double getDoubleValue() {
        return 3;
    }
}

public class SupplierExercise {
    public static void main(String[] args) {
        System.out.println("- Tạo Supplier bằng lambda expression");
        Supplier<String> supplier = () -> "My name is Phong";

        System.out.println(supplier.get());

        System.out.println("- Tạo supplier bằng method reference");

        Supplier<Programing>  supplier1 = Programing::new;
        Programing lang = supplier1.get();
        lang.print();

        Supplier<String> supplier2 = Programing::getDefaultLangue;
        String defaultLang = supplier2.get();
        System.out.println("Default language: " + defaultLang);

        System.out.println("- Primitive types");
        BooleanSupplier bs = NumberUtils::getBooleanValue;
        System.out.println("Boolean Value: " + bs.getAsBoolean());

        IntSupplier dbs = NumberUtils::getIntValue;
        System.out.println("Integer Value: " + dbs.getAsInt());

        LongSupplier ls = NumberUtils::getLongValue;
        System.out.println("Long Value: " + ls.getAsLong());

        DoubleSupplier ds = NumberUtils::getDoubleValue;
        System.out.println("Double Value: " + ds.getAsDouble());
    }
}
