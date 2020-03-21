package main.canil.models;

public class Kennel {

    private Long id;

    private String name;

    private Integer distance;

    private Float priceSmall;

    private Float priceBig;

    public Kennel() {

    }

    public Kennel(Long id, String name, Integer distance, Float priceSmall, Float priceBig) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.priceSmall = priceSmall;
        this.priceBig = priceBig;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Float getPriceSmall() {
        return priceSmall;
    }

    public void setPriceSmall(Float priceSmall) {
        this.priceSmall = priceSmall;
    }

    public Float getPriceBig() {
        return priceBig;
    }

    public void setPriceBig(Float priceBig) {
        this.priceBig = priceBig;
    }
}
