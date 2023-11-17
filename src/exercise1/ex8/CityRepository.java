package exercise1.ex8;

import java.util.HashMap;
import java.util.Map;

public class CityRepository {
    Map<Integer, City> map = new HashMap<>();

    public CityRepository(){
        this.map = map;
    }

    public void addCity(City city){
        map.put(city.getId(), city);
    }

    public City getCity(int id){
        return map.get(id);
    }
}
