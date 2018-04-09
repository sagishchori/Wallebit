package wallebit.sagishchori.com.wallebit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import wallebit.sagishchori.com.wallebit.R;
import wallebit.sagishchori.com.wallebit.model.CurrencyDataModel;
import wallebit.sagishchori.com.wallebit.views.CurrencyListViewItemViewHolder;

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListViewItemViewHolder>
{
    private ArrayList<CurrencyDataModel> currencyList;

    public CurrencyListAdapter(ArrayList<CurrencyDataModel> currencyList)
    {
        this.currencyList = currencyList;
        currencyList.add(new CurrencyDataModel());
    }

    @NonNull
    @Override
    public CurrencyListViewItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_list_item, parent, false);
        return new CurrencyListViewItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyListViewItemViewHolder holder, int position)
    {
        CurrencyDataModel model = currencyList.get(position);

        holder.bindData(model);
    }

    @Override
    public int getItemCount()
    {
        if (currencyList == null)
            return 0;
        else
            return currencyList.size();
    }
}