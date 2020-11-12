package com.example.ca1_20325.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ca1_20325.Product;
import com.example.ca1_20325.R;

import java.util.List;

public class adapterListProducts extends BaseAdapter {
    private Context context;
    private List<Product>productList;

    public adapterListProducts(Context context, List<Product>productList){
        this.context=context;
        this.productList=productList;
    }

    @Override
    public int getCount() {
        return this.productList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void removeProduct (int position) {
       this.productList.remove(position);
       notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v= View.inflate(this.context, R.layout.layout_product, null);
        TextView tvNameProduct = (TextView) v.findViewById(R.id.tvNameProduct);
        TextView tvPriceProduct = (TextView) v.findViewById(R.id.tvPriceProduct);
        TextView tvQtdProduct = (TextView) v.findViewById(R.id.tvQtdProduct);

        tvNameProduct.setText(this.productList.get(position).getName());
        tvPriceProduct.setText(String.valueOf(this.productList.get(position).getPrice()));
        tvQtdProduct.setText(String.valueOf(this.productList.get(position).getQuantity()));


        return v;
    }
}
