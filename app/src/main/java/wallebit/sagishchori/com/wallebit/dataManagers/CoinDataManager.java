package wallebit.sagishchori.com.wallebit.dataManagers;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import wallebit.sagishchori.com.wallebit.model.CurrencyDataModel;
import wallebit.sagishchori.com.wallebit.model.CurrencyPriceDataModel;
import wallebit.sagishchori.com.wallebit.model.URLParams;
import wallebit.sagishchori.com.wallebit.restClient.HttpTaskResponse;
import wallebit.sagishchori.com.wallebit.restClient.RestAPIClient;

public class CoinDataManager extends AbstractDataManager<String>
{
    private static final String BASE_URL = "https://www.cryptocompare.com/api/data/";
    private static final String BASE_URL_2 = "https://min-api.cryptocompare.com/data/";

    private static final String COINS_SEGMENT = "coinlist/";
    private static final String PRICE_SEGMENT = "price?";
    private final Context context;

    private ArrayList<CurrencyDataModel> allCoinsDataList;
    private HashMap<String, CurrencyDataModel> allCoinsDataHashMap;
    private ArrayList<CurrencyPriceDataModel> allCoinsPriceDataList;
    private RestAPIClient client;

    private static CoinDataManager coinDataManager;

    private CoinDataManager(Context applicationContext)
    {
        this.context = applicationContext;

        allCoinsDataList = new ArrayList<>();
        allCoinsDataHashMap = new HashMap<>();

        allCoinsPriceDataList = new ArrayList<>();
    }

    public static CoinDataManager getInstance(Context context)
    {
        if (coinDataManager == null)
            coinDataManager = new CoinDataManager(context);

        return coinDataManager;
    }

    public void getAllCoinsDataList(boolean isNewAPI, HttpTaskResponse taskResponse)
    {
        if (allCoinsDataList == null || allCoinsDataList.size() == 0)
        {
            client = RestAPIClient.getInstance(context);
            client.setDataManager(this);
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

    @Override
    public void saveData(String data)
    {
        try {
            JSONObject mainJsonObject = new JSONObject(data);
            JSONObject dataJsonObject = mainJsonObject.getJSONObject("Data");
            Iterator<String> iterator = dataJsonObject.keys();

            while (iterator.hasNext())
            {
                String key = iterator.next();
                String coinObject = dataJsonObject.getJSONObject(key).toString();

                Gson gson = new Gson();
                CurrencyDataModel model = gson.fromJson(coinObject, CurrencyDataModel.class);

//                allCoinsDataList.add(model);
                allCoinsDataHashMap.put(model.getName(), model);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
