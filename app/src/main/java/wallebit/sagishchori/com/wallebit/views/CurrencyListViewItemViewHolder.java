package wallebit.sagishchori.com.wallebit.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import wallebit.sagishchori.com.wallebit.R;
import wallebit.sagishchori.com.wallebit.model.CurrencyDataModel;

public class CurrencyListViewItemViewHolder extends RecyclerView.ViewHolder
{
    private CircleImageView circleImageView;
    private TextView currencyName;
    private TextView currencySymbol;
    private TextView currencyBitPrice;
    private TextView currencyPrice;

    public CurrencyListViewItemViewHolder(View itemView)
    {
        super(itemView);

        circleImageView = (CircleImageView) itemView.findViewById(R.id.currency_list_item_icon_imageView);
        currencyName = (TextView) itemView.findViewById(R.id.currency_list_item_currency_name);
        currencySymbol = (TextView) itemView.findViewById(R.id.currency_list_item_currency_symbol);
        currencyBitPrice = (TextView) itemView.findViewById(R.id.currency_list_item_currency_bit_price);
        currencyPrice = (TextView) itemView.findViewById(R.id.currency_list_item_currency_price);
    }

    private void setCurrencyName(String currencyName)
    {
        this.currencyName.setText(currencyName);
    }

    private void setCurrencySymbol(String currencySymbol)
    {
        this.currencySymbol.setText(currencySymbol);
    }

    private void setCurrencyBitPrice(String currencyBitPrice)
    {
        this.currencyBitPrice.setText(currencyBitPrice);
    }

    private void setCurrencyPrice(String currencyPrice)
    {
        this.currencyPrice.setText(currencyPrice);
    }

    /**
     * Set the data to view.
     * @param model The data model
     */
    public void bindData(CurrencyDataModel model)
    {
        setCurrencyName(model.getName());
        setCurrencySymbol(model.getSymbol());
        setCurrencyBitPrice(model.getPriceBtc());
        setCurrencyPrice(model.getPriceUsd());
    }
}