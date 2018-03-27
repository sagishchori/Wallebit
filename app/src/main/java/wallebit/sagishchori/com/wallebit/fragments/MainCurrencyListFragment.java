package wallebit.sagishchori.com.wallebit.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wallebit.sagishchori.com.wallebit.R;

/**
 * A class to handle the main user currency list.
 */
public class MainCurrencyListFragment extends Fragment
{

    public static final String TAG = MainCurrencyListFragment.class.getSimpleName();

    private RecyclerView recyclerView;

    public MainCurrencyListFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.currency_list_recyclerView);
    }
}
