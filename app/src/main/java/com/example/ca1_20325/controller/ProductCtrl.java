package com.example.ca1_20325.controller;

import com.example.ca1_20325.DAO.ProductDAO;
import com.example.ca1_20325.Product;
import com.example.ca1_20325.dbHelper.ConnectionSQLite;

import java.util.List;

public class ProductCtrl {
    private final ProductDAO productDAO;

    public ProductCtrl(ConnectionSQLite pConnectionSQLite) {
    productDAO = new ProductDAO(pConnectionSQLite);
    }

    public long saveProductCtrl (Product pProduct) {
        return this.productDAO.saveProductDAO(pProduct);
        //*********************************************
    }

    public List<Product>getListProductsCtrl(){
        return this.productDAO.getListProductDAO();
    }

    public boolean deleteProductCtrl(long pIdProduct){
        return this.productDAO.deleteProductDAO(pIdProduct);
    }

    public boolean refreshProductCtrl(Product pProduct){
        return this.productDAO.refreshProductDAO(pProduct);
    }

}
