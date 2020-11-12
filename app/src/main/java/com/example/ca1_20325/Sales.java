package com.example.ca1_20325;

import java.util.Date;

public class Sales {

    private long id;
    private Product productSold;
    private Date dateSold;
    private String nameCustomer;

    public Sales() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProductSold() {
        return productSold;
    }

    public void setProductSold(Product productSold) {
        this.productSold = productSold;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", productSold=" + productSold.toString() +
                ", dateSold=" + dateSold +
                ", nameCustomer='" + nameCustomer + '\'' +
                '}';
    }
}
