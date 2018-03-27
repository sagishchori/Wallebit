package wallebit.sagishchori.com.wallebit.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import wallebit.sagishchori.com.wallebit.R;
import wallebit.sagishchori.com.wallebit.adapters.CurrencyListAdapter;
import wallebit.sagishchori.com.wallebit.model.CurrencyDataModel;

/**
 * A class to handle the main user currency list.
 */
public class MainCurrencyListFragment extends Fragment
{
    public static final String TAG = MainCurrencyListFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private CurrencyListAdapter adapter;

    public MainCurrencyListFragment()
    {
    }

    public static MainCurrencyListFragment getInstance(Bundle bundle)
    {
        MainCurrencyListFragment fragment = new MainCurrencyListFragment();

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_main_currency_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.currency_list_recyclerView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new CurrencyListAdapter(new ArrayList<CurrencyDataModel>());

        recyclerView.setAdapter(adapter);
    }
}
