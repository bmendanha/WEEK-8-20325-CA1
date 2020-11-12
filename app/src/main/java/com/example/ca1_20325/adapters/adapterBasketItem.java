package com.example.ca1_20325.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ca1_20325.BasketItem;
import com.example.ca1_20325.R;

import java.util.List;

public class adapterBasketItem extends BaseAdapter {
    private Context context;
    private List<BasketItem>basketItems;

    public adapterBasketItem(Context context, List<BasketItem> basketItems){
        this.context=context;
        this.basketItems = basketItems;
    }

    @Override
    public int getCount() {
        return this.basketItems.size();
    }

    @Override
    public Object getItem(int position) {
        return this.basketItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public boolean removeItemBasket (int position) {
       this.basketItems.remove(position);
       notifyDataSetChanged();
       return true;

    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v= View.inflate(this.context, R.layout.layout_basket, null);
        TextView tvNameProduct = (TextView) v.findViewById(R.id.tvNameProduct);
        TextView tvPriceProduct = (TextView) v.findViewById(R.id.tvPriceProduct);
        TextView tvQtdProduct = (TextView) v.findViewById(R.id.tvQtdProduct);
        TextView tvValueItem = (TextView) v.findViewById(R.id.tvValueTotalItem);

        tvNameProduct.setText(this.basketItems.get(position).getName());
        tvPriceProduct.setText(String.valueOf(this.basketItems.get(position).getPriceProduct()));
        tvQtdProduct.setText(String.valueOf(this.basketItems.get(position).getQtdSelected()));
        tvValueItem.setText(String.valueOf(this.basketItems.get(position).getPriceUnit()));

        return v;
    }

    // add item in the basket
    public void addItemBasket (BasketItem pBasketItem){
        this.basketItems.add(pBasketItem);
        this.notifyDataSetChanged();

    }

    public void refresh (List<BasketItem> pBasketItems){
        this.basketItems.clear();
        this.basketItems = pBasketItems;
        this.notifyDataSetChanged();
    }
}
