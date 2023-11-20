package exercise1.ex8;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex8 {
    public static void main(String[] args) throws IOException {
        writeObjet();
        List<City> cities = new ArrayList<>();
        List<Country> countries = new ArrayList<>();

        try {
            FileInputStream countryFile = new FileInputStream("src/exercise1/ex8/countries.dat");
            ObjectInputStream countryInput = new ObjectInputStream(countryFile);

            FileInputStream cityFile = new FileInputStream("src/exercise1/ex8/cities.dat");
            ObjectInputStream cityInput = new ObjectInputStream(cityFile);

            // Đọc danh sách quốc gia từ file
            while (true) {
                try {
                    Country country = (Country) countryInput.readObject();
                    countries.add(country);
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
                    cities.add(city);
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

        // 1.1 Tìm thành phố đông dân nhất của mỗi quốc gia.
        Map<String, Optional<City>> mostPopulousCityByCountry = cities.stream()
                .collect(Collectors.groupingBy(City::getCode,
                        Collectors.maxBy(Comparator.comparingInt(City::getPopulation))));

        // 1.2 Tìm thành phố đông dân nhất của mỗi lục địa.
        Map<String, Optional<City>> mostPopulousCityByContinent = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent, Collectors.mapping(
                        country -> mostPopulousCityByCountry.getOrDefault(country.getCode(), Optional.empty())
                                .orElse(null),
                        Collectors.maxBy(Comparator.comparingInt(city -> city != null ? city.getPopulation() : 0))
                )));

        // 1.3 Tìm thành phố là thủ đô, đông dân nhất.
        Optional<City> mostPopulousCapital = countries.stream()
                .map(country -> cities.stream()
                        .filter(city -> city.getId() == country.getCapital())
                        .max(Comparator.comparingInt(City::getPopulation)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .max(Comparator.comparingInt(City::getPopulation));

        // 1.4 Tìm thành phố là thủ đô, đông dân nhất của mỗi lục địa.
        Map<String, Optional<City>> mostPopulousCapitalByContinent = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent, Collectors.mapping(
                        country -> cities.stream()
                                .filter(city -> city.getId() == country.getCapital())
                                .max(Comparator.comparingInt(City::getPopulation))
                                .orElse(null),
                        Collectors.maxBy(Comparator.comparingInt(city -> city != null ? city.getPopulation() : 0))
                )));

//        // 1.5 Sắp xếp các quốc gia theo số lượng thành phố giảm dần.
        List<Country> countriesByCityCount = new ArrayList<>(countries.stream()
                .sorted(Comparator.comparing(country ->
                        cities.stream().filter(city -> city.getCode().equals(country.getCode())).count())).toList());
        Collections.reverse(countriesByCityCount);

//        // 1.6 Sắp xếp các quốc gia theo mật độ dân số theo thứ tự giảm dần bỏ qua các quốc gia có dân số bằng không.
        List<Country> countriesByPopulationDensity = new ArrayList<>(countries.stream()
                .filter(country -> country.getPopulation() > 0)
                .sorted(Comparator.comparingDouble(country -> country.getPopulation() / country.getSurfaceArea())).toList());
        Collections.reverse(countriesByPopulationDensity);


        // 1.1 Tìm thành phố đông dân nhất của mỗi quốc gia.
        System.out.println("Thành phố đông dân nhất của mỗi quốc gia:");
        mostPopulousCityByCountry.forEach((countryCode, city) -> {
            if (city.isPresent()) {
                System.out.printf("Quốc gia %s: %s, Dân số: %d\n",
                        countryCode, city.get().getName(), city.get().getPopulation());
            }
        });

        // 1.2 Tìm thành phố đông dân nhất của mỗi lục địa.
        System.out.println("\nThành phố đông dân nhất của mỗi lục địa:");
        mostPopulousCityByContinent.forEach((continent, city) -> {
            if (city.isPresent()) {
                System.out.printf("Lục địa %s: %s, Dân số: %d\n",
                        continent, city.get().getName(), city.get().getPopulation());
            }
        });

        // 1.3 Tìm thành phố là thủ đô, đông dân nhất.
        if (mostPopulousCapital.isPresent()) {
            System.out.println("\nThành phố là thủ đô, đông dân nhất:");
            System.out.printf("%s, Dân số: %d\n",
                    mostPopulousCapital.get().getName(), mostPopulousCapital.get().getPopulation());
        }

        // 1.4 Tìm thành phố là thủ đô, đông dân nhất của mỗi lục địa.
        System.out.println("\nThành phố là thủ đô, đông dân nhất của mỗi lục địa:");
        mostPopulousCapitalByContinent.forEach((continent, city) -> {
            if (city.isPresent()) {
                System.out.printf("Lục địa %s: %s, Dân số: %d\n",
                        continent, city.get().getName(), city.get().getPopulation());
            }
        });

        // 1.5 Sắp xếp các quốc gia theo số lượng thành phố giảm dần.
        System.out.println("\nSắp xếp các quốc gia theo số lượng thành phố giảm dần:");
        countriesByCityCount.forEach(country -> {
            System.out.printf("Quốc gia %s: Số lượng thành phố - %d\n",
                    country.getCode(), cities.stream().filter(city -> city.getCode().equals(country.getCode())).count());
        });

        // 1.6 Sắp xếp các quốc gia theo mật độ dân số theo thứ tự giảm dần bỏ qua các quốc gia có dân số bằng không.
        System.out.println("\nSắp xếp các quốc gia theo mật độ dân số theo thứ tự giảm dần:");
        countriesByPopulationDensity.forEach(country -> {
            double populationDensity = (double) country.getPopulation() / country.getSurfaceArea();
            System.out.printf("Quốc gia %s: Mật độ dân số - %.2f\n",
                    country.getCode(), populationDensity);
        });
    }

    public static void writeObjet() throws IOException {
        Country country1 = new Country("VN", "Viet Nam", "ASIA", 700000.0, 90000000, 1.5, 1);
        Country country2 = new Country("NB", "Nhat Ban", "ASIA", 570000.0, 8000000, 1.4, 4);
        Country country3 = new Country("HQ", "Han Quoc", "ASIA", 690000.0, 72000000, 1.6, 5);
        Country country4 = new Country("GM", "Duc", "EUROPE", 690000.0, 72000000, 1.6, 7);

        List<Country> listCountry = new ArrayList<>();
        listCountry.add(country1);
        listCountry.add(country2);
        listCountry.add(country3);
        listCountry.add(country4);

        FileOutputStream fos = new FileOutputStream("src/exercise1/ex8/countries.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Country country : listCountry){
            oos.writeObject(country);
        }

        City city1 = new City(1, "VN", "Ha Noi", 10000000);
        City city2 = new City(2, "VN", "Ho Chi Minh", 6300000);
        City city3 = new City(3, "NB", "Osaka", 5300000);
        City city4 = new City(4, "NB", "Tokyo", 310000);
        City city5 = new City(5, "HQ", "Busan", 45000000);
        City city6 = new City(6, "HQ", "Gangnam", 70000000);
        City city7 = new City(7, "GM", "Berlin", 4000000);

        List<City> listCity = new ArrayList<>();
        listCity.add(city1);
        listCity.add(city2);
        listCity.add(city3);
        listCity.add(city4);
        listCity.add(city5);
        listCity.add(city6);
        listCity.add(city7);

        fos = new FileOutputStream("src/exercise1/ex8/cities.dat");
        oos = new ObjectOutputStream(fos);

        for (City city : listCity){
            oos.writeObject(city);
        }

        oos.close();
        fos.close();
    }
}
