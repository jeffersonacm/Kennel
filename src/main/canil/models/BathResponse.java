package main.canil.models;

public class BathResponse {

    private Kennel kennel;

    private Float totalPrice;

    public BathResponse() {

    }

    public BathResponse(Kennel kennel, Float totalPrice) {
        this.kennel = kennel;
        this.totalPrice = totalPrice;
    }

    public Kennel getKennel() {
        return kennel;
    }

    public void setKennel(Kennel kennel) {
        this.kennel = kennel;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }



}
