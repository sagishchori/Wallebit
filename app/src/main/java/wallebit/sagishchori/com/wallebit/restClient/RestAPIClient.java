package wallebit.sagishchori.com.wallebit.restClient;

import android.content.Context;

import wallebit.sagishchori.com.wallebit.dataManagers.AbstractDataManager;
import wallebit.sagishchori.com.wallebit.dataManagers.CoinDataManager;
import wallebit.sagishchori.com.wallebit.utils.ConnectionUtils;

public class RestAPIClient
{
    private static RestAPIClient restAPIClient;
    private final Context context;
    private String baseURL;
    private String urlParams;

    private HttpGetTask getTask;
    private AbstractDataManager dataManager;

    private RestAPIClient(Context context)
    {
        this.context = context;
    }

    public static RestAPIClient getInstance(Context context)
    {
        if (restAPIClient == null)
            restAPIClient = new RestAPIClient(context);

        return restAPIClient;
    }

    public static RestAPIClient setBaseURL(String baseURL)
    {
        restAPIClient.baseURL = baseURL;
        return restAPIClient;
    }

    public static RestAPIClient setURLParams(String urlParams)
    {
        restAPIClient.urlParams = urlParams;
        return restAPIClient;
    }

    public String getFullURL()
    {
        return baseURL + urlParams;
    }

    public void execute(HttpTaskResponse taskResponse)
    {
        cancelGetTask();

        getTask = new HttpGetTask(getFullURL(), taskResponse, context);
        getTask.setDataManager(dataManager);
        getTask.execute(this);

    }

    public void cancelGetTask()
    {
        if (getTask != null)
            getTask.cancel(true);
    }

    public void setDataManager(AbstractDataManager dataManager)
    {
        this.dataManager = dataManager;
    }
}
