package com.example.ca1_20325;

public class BasketItem {
    private long id;
    private String name;
    private int qtdSelected;
    private double priceProduct;
    private double priceOfItem; //priceOfItem = qtdSelected*price

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtdSelected() {
        return qtdSelected;
    }

    public void setQtdSelected(int qtdSelected) {
        this.qtdSelected = qtdSelected;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public double getPriceUnit() {
        return priceOfItem;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceOfItem = priceUnit;
    }
}
