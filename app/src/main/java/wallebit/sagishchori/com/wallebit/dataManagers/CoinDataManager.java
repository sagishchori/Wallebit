package wallebit.sagishchori.com.wallebit.dataManagers;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import wallebit.sagishchori.com.wallebit.model.CurrencyDataModel;
import wallebit.sagishchori.com.wallebit.model.CurrencyPriceDataModel;
import wallebit.sagishchori.com.wallebit.model.URLParams;
import wallebit.sagishchori.com.wallebit.restClient.HttpTaskResponse;
import wallebit.sagishchori.com.wallebit.restClient.RestAPIClient;

public class CoinDataManager extends AbstractDataManager<String>
{
    /**
     * Old API - old end point.
     */
    private static final String BASE_URL = "https://www.cryptocompare.com/api/data/";

    /**
     * New API - new end point.
     */
    private static final String BASE_URL_2 = "https://min-api.cryptocompare.com/data/";

    /**
     * Use this to fetch all coins's data.
     */
    private static final String COINS_SEGMENT = "coinlist/";

    /**
     * Use this to fetch a specific coins' data.
     */
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

    /**
     * A method to get all the data of all coins.
     *
     * @param isNewAPI      true - if using new API, false - if using old API.
     * @param taskResponse  HttpTaskResponse interface to notify about the task stages.
     */
    public void getAllCoinsDataList(boolean isNewAPI, HttpTaskResponse taskResponse)
    {
        if (allCoinsDataList == null || allCoinsDataList.size() == 0)
        {
            // Instantiate the RestAPIClient.
            client = RestAPIClient.getInstance(context);

            // Set the DataManager to the RestAPIClient.
            client.setDataManager(this);

            if (!isNewAPI)
                client.setBaseURL(BASE_URL + COINS_SEGMENT);
            else
                client.setBaseURL(BASE_URL_2);

            // Set other params to URL.
            client.setURLParams("").execute(taskResponse);
        }
    }

    /**
     * A method to get the price of a specific coin.
     *
     * @param fromCoin  Which coin the user asks the value for.
     * @param toCoins   Which coins convert the {@param fromCoin} to.
     */
    public void getAllCoinsPriceDataList(String fromCoin, String toCoins)
    {
        if (allCoinsPriceDataList == null || allCoinsPriceDataList.size() == 0)
        {
            client = RestAPIClient.getInstance(context).setBaseURL(BASE_URL).setURLParams(PRICE_SEGMENT + new URLParams(fromCoin, toCoins).toString());
//            client.execute();
        }
    }

    /**
     * A method to cancel AsyncTask that is currently running.
     */
    public void close()
    {
        client.cancelGetTask();
    }

    @Override
    public void saveData(String data)
    {
        try {
            // Get the JSONObject from the data String.
            JSONObject mainJsonObject = new JSONObject(data);

            // Get the JSONObject containing the coins' data.
            JSONObject dataJsonObject = mainJsonObject.getJSONObject("Data");

            Iterator<String> iterator = dataJsonObject.keys();

            while (iterator.hasNext())
            {
                String key = iterator.next();
                String coinObject = dataJsonObject.getJSONObject(key).toString();

                Gson gson = new Gson();
                CurrencyDataModel model = gson.fromJson(coinObject, CurrencyDataModel.class);

//                allCoinsDataList.add(model);

                // Adding each coin to HashMAap in order to prevent searching for value in complexity > O(1).
                allCoinsDataHashMap.put(model.getName(), model);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
