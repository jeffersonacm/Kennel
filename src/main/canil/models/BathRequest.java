package main.canil.models;

import java.time.LocalDate;

public class BathRequest {

    private LocalDate date;

    private Integer smallDogs;

    private Integer bigDogs;


    public BathRequest() {

    }

    public BathRequest(LocalDate date, Integer smallDogs, Integer bigDogs) {
        this.date = date;
        this.smallDogs = smallDogs;
        this.bigDogs = bigDogs;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getSmallDogs() {
        return smallDogs;
    }

    public void setSmallDogs(Integer smallDogs) {
        this.smallDogs = smallDogs;
    }

    public Integer getBigDogs() {
        return bigDogs;
    }

    public void setBigDogs(Integer bigDogs) {
        this.bigDogs = bigDogs;
    }

}
