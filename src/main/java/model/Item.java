package model;


import pricing.PriceStrategy;

public class Item implements PriceStrategy{

    private String name;
    private double unitPrice;

    private String description;

    private PriceStrategy priceStrategy;

    public Item(String name, double unitPrice, String description, PriceStrategy priceStrategy) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.description = description;
        this.priceStrategy=priceStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double calculatePrice(double unitPrice, int quantity) {
        return priceStrategy.calculatePrice(unitPrice,quantity);
    }

}
