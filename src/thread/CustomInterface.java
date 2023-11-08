package thread;

interface CustomizeInterface{
    void display();
}

public class CustomInterface {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        CustomizeInterface c1 = () ->{
            System.out.println("Display something");
        };

        c1.display();

        CustomizeInterface c2 = new CustomizeInterface() {
            @Override
            public void display() {
                System.out.println("Display something using Lambda expression");
            }
        };

        c2.display();
    }
}
