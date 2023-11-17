package exercise1.ex8;

import java.util.HashMap;
import java.util.Map;

public class CountryRepository {
    Map<String, Country> map = new HashMap<>();
    public CountryRepository(){
        this.map = map;
    }

    public void addCountry(Country country){
        map.put(country.getCode(), country);
    }

    public Country getCountry(String code){
        return map.get(code);
    }
}
