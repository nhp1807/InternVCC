package exercise1.ex8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex8 {
    public static void main(String[] args) throws IOException {
        writeObjet();

        try {
            FileInputStream countryFile = new FileInputStream("src/exercise1/ex8/countries.dat");
            ObjectInputStream countryInput = new ObjectInputStream(countryFile);

            FileInputStream cityFile = new FileInputStream("src/exercise1/ex8/cities.dat");
            ObjectInputStream cityInput = new ObjectInputStream(cityFile);

            // Đọc danh sách quốc gia từ file
            while (true) {
                try {
                    Country country = (Country) countryInput.readObject();
                    // Thực hiện xử lý với đối tượng quốc gia đọc được
                    System.out.println(country.toString());
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }

            // Đọc danh sách thành phố từ file
            while (true) {
                try {
                    City city = (City) cityInput.readObject();
                    // Thực hiện xử lý với đối tượng thành phố đọc được
                    System.out.println(city.toString());
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }

            // Đóng luồng sau khi sử dụng
            countryInput.close();
            cityInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeObjet() throws IOException {
        Country country1 = new Country("VN", "Viet Nam", "ASIA", 700000.0, 90000000, 1.5, 1);
        Country country2 = new Country("NB", "Nhat Ban", "ASIA", 570000.0, 8000000, 1.4, 2);
        Country country3 = new Country("HQ", "Han Quoc", "ASIA", 690000.0, 72000000, 1.6, 3);

        List<Country> listCountry = new ArrayList<>();
        listCountry.add(country1);
        listCountry.add(country2);
        listCountry.add(country3);

        FileOutputStream fos = new FileOutputStream("src/exercise1/ex8/countries.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Country country : listCountry){
            oos.writeObject(country);
        }

        City city1 = new City(1, "Ha Noi", 10000000);
        City city2 = new City(2, "Osaka", 5300000);
        City city3 = new City(3, "Busan", 64000000);

        List<City> listCity = new ArrayList<>();
        listCity.add(city1);
        listCity.add(city2);
        listCity.add(city3);

        fos = new FileOutputStream("src/exercise1/ex8/cities.dat");
        oos = new ObjectOutputStream(fos);

        for (City city : listCity){
            oos.writeObject(city);
        }

        oos.close();
        fos.close();
    }
}
