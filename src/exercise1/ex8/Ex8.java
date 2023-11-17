package exercise1.ex8;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Ex8 {
    static CityRepository cityRepository = new CityRepository();
    static CountryRepository countryRepository = new CountryRepository();
    public static void main(String[] args) throws IOException {
        writeObjet();
        List<City> listCity = new ArrayList<>();
        List<Country> listCountry = new ArrayList<>();

        try {
            FileInputStream countryFile = new FileInputStream("src/exercise1/ex8/countries.dat");
            ObjectInputStream countryInput = new ObjectInputStream(countryFile);

            FileInputStream cityFile = new FileInputStream("src/exercise1/ex8/cities.dat");
            ObjectInputStream cityInput = new ObjectInputStream(cityFile);

            // Đọc danh sách quốc gia từ file
            while (true) {
                try {
                    Country country = (Country) countryInput.readObject();
                    countryRepository.addCountry(country);
                    listCountry.add(country);
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
                    cityRepository.addCity(city);
                    // Thực hiện xử lý với đối tượng thành phố đọc được
                    listCity.add(city);
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

//        Map<String, Optional<City>> mostPopulousCitiesByCountry = listCity.stream()
//                .collect(Collectors.groupingBy(City::getCode, Collectors.maxBy(Comparator.comparingInt(City::getPopulation))));
//
//        mostPopulousCitiesByCountry.forEach((countryCode, city) -> {
//            city.ifPresent(c -> System.out.println("Ma quoc gia: " + countryCode +
//                    ", Thanh pho dong dan nhat: " + c.getName() +
//                    ", Dan so: " + c.getPopulation()));
//        });

        Map<String, City> mostPopulousCityByCountry = new HashMap<>();

        for (Country country : listCountry) {
            int maxPopulation = 0;
            City mostPopulousCity = null;

            for (City city : listCity) {
                if (city.getCode().equals(country.getCode())) {
                    if (city.getPopulation() > maxPopulation) {
                        maxPopulation = city.getPopulation();
                        mostPopulousCity = city;
                    }
                }
            }

            if (mostPopulousCity != null) {
                mostPopulousCityByCountry.put(country.getName(), mostPopulousCity);
            }
        }

        System.out.println();

        // In ra thành phố đông dân nhất của mỗi quốc gia
        for (Map.Entry<String, City> entry : mostPopulousCityByCountry.entrySet()) {
            String countryName = entry.getKey();
            City mostPopulousCity = entry.getValue();
            System.out.println("Quoc gia: " + countryName +
                    ", Thanh pho dong dan nhat: " + mostPopulousCity.getName() +
                    ", Dan so: " + mostPopulousCity.getPopulation());
        }

        System.out.println();

//        Map<String, Optional<City>> mostPopulousCitiesByContinent = listCountry.stream()
//                .collect(Collectors.groupingBy(Country::getContinent,
//                        Collectors.mapping(country -> getMostPopulousCityForCountry(listCity, country),
//                                Collectors.maxBy(Comparator.comparingInt(city -> city.getPopulation())))));
//
//        mostPopulousCitiesByContinent.forEach((continent, city) -> {
//            city.ifPresent(c -> System.out.println("Luc dia: " + continent +
//                    ", Thanh pho dong dan nhat: " + c.getName() +
//                    ", Dan so: " + c.getPopulation()));
//        });

        Map<String, City> mostPopulousCityByContinent = new HashMap<>();

        for (Country country : listCountry) {
            int maxPopulation = 0;
            City mostPopulousCity = null;

            for (City city : listCity) {
                if (city.getCode().equals(country.getCode())) {
                    if (city.getPopulation() > maxPopulation) {
                        maxPopulation = city.getPopulation();
                        mostPopulousCity = city;
                    }
                }
            }

            if (mostPopulousCity != null) {
                String continent = country.getContinent();
                if (!mostPopulousCityByContinent.containsKey(continent) ||
                        mostPopulousCity.getPopulation() > mostPopulousCityByContinent.get(continent).getPopulation()) {
                    mostPopulousCityByContinent.put(continent, mostPopulousCity);
                }
            }
        }

        // In ra thành phố đông dân nhất của mỗi lục địa
        for (Map.Entry<String, City> entry : mostPopulousCityByContinent.entrySet()) {
            String continent = entry.getKey();
            City mostPopulousCity = entry.getValue();
            System.out.println("Luc dia: " + continent +
                    ", Thanh pho dong dan nhat: " + mostPopulousCity.getName() +
                    ", Dan so: " + mostPopulousCity.getPopulation());
        }

        System.out.println();

        Map<String, City> mostPopulousCapitalByContinent = new HashMap<>();

        for (Country country : listCountry) {
            int capitalId = country.getCapital();
            City capitalCity = null;

            for (City city : listCity) {
                if (city.getId() == capitalId) {
                    if (capitalCity == null || city.getPopulation() > capitalCity.getPopulation()) {
                        capitalCity = city;
                    }
                }
            }

            if (capitalCity != null) {
                String continent = country.getContinent();
                if (!mostPopulousCapitalByContinent.containsKey(continent) ||
                        capitalCity.getPopulation() > mostPopulousCapitalByContinent.get(continent).getPopulation()) {
                    mostPopulousCapitalByContinent.put(continent, capitalCity);
                }
            }
        }

        // In ra thành phố thủ đô, đông dân nhất của mỗi lục địa
        for (Map.Entry<String, City> entry : mostPopulousCapitalByContinent.entrySet()) {
            String continent = entry.getKey();
            City capitalCity = entry.getValue();
            System.out.println("Luc dia: " + continent +
                    ", Thu do dong dan nhat: " + capitalCity.getName() +
                    ", Dan so: " + capitalCity.getPopulation());
        }

        System.out.println();

        Map<String, Integer> cityCountByCountry = new HashMap<>();
//        for(City city : listCity){
//            String code = city.getCode();
//            cityCountByCountry.put(code, cityCountByCountry.getOrDefault(code, 0) + 1);
//        }

        listCity.forEach(city -> cityCountByCountry.put(city.getCode(), cityCountByCountry.getOrDefault(city.getCode(),0) + 1));

        listCountry.sort(Comparator.comparingInt(country -> cityCountByCountry.get(country.getCode())));
//        for(Country country : listCountry){
//            int cityCount = cityCountByCountry.get(country.getCode());
//            System.out.println("Quoc gia: " + country.getName() + " : " + cityCount);
//        }

        listCountry.forEach(country -> System.out.println("Quoc gia: " + country.getName() + ":" + cityCountByCountry.get(country.getCode())));

    }

    private static City getMostPopulousCityForCountry(List<City> listCity, Country country) {
        return listCity.stream()
                .filter(city -> city.getCode().equals(country.getCode()))
                .max(Comparator.comparingInt(City::getPopulation))
                .orElse(null);
    }

    public static void writeObjet() throws IOException {
        Country country1 = new Country("VN", "Viet Nam", "ASIA", 700000.0, 90000000, 1.5, 1);
        Country country2 = new Country("NB", "Nhat Ban", "ASIA", 570000.0, 8000000, 1.4, 2);
        Country country3 = new Country("HQ", "Han Quoc", "ASIA", 690000.0, 72000000, 1.6, 3);
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
