package wallebit.sagishchori.com.wallebit.dataManagers;

import android.content.Context;

import java.util.ArrayList;

import wallebit.sagishchori.com.wallebit.model.CurrencyDataModel;
import wallebit.sagishchori.com.wallebit.model.CurrencyPriceDataModel;
import wallebit.sagishchori.com.wallebit.model.URLParams;
import wallebit.sagishchori.com.wallebit.restClient.HttpTaskResponse;
import wallebit.sagishchori.com.wallebit.restClient.RestAPIClient;

public class CoinDataManager
{
    private static final String BASE_URL = "https://www.cryptocompare.com/api/data/";
    private static final String BASE_URL_2 = "https://min-api.cryptocompare.com/data/";

    private static final String COINS_SEGMENT = "coinlist/";
    private static final String PRICE_SEGMENT = "price?";
    private final Context context;

    private ArrayList<CurrencyDataModel> allCoinsDataList;
    private ArrayList<CurrencyPriceDataModel> allCoinsPriceDataList;
    private RestAPIClient client;

    public CoinDataManager(Context applicationContext)
    {
        this.context = applicationContext;
    }

    public void getAllCoinsDataList(boolean isNewAPI, HttpTaskResponse taskResponse)
    {
        if (allCoinsDataList == null || allCoinsDataList.size() == 0)
        {
            client = RestAPIClient.getInstance(context);
            if (!isNewAPI)
                client.setBaseURL(BASE_URL + COINS_SEGMENT);
            else
                client.setBaseURL(BASE_URL_2);

            client.setURLParams("").execute(taskResponse);
        }
    }

    public void getAllCoinsPriceDataList(String fromCoin, String toCoins)
    {
        if (allCoinsPriceDataList == null || allCoinsPriceDataList.size() == 0)
        {
            client = RestAPIClient.getInstance(context).setBaseURL(BASE_URL).setURLParams(PRICE_SEGMENT + new URLParams(fromCoin, toCoins).toString());
//            client.execute();
        }
    }

    public void close()
    {
        client.cancelGetTask();
    }
}
