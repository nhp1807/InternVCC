package exercise1.ex8;

import java.io.Serializable;

public class City implements Serializable {
    private int id; // Ma thanh pho
    private String code; // Ma quoc gia
    private String name;
    private int population;

    public City(){

    }

    public City(int id, String code, String name, int population) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return id + "," + code + "," + name + "," + population;
    }
}
