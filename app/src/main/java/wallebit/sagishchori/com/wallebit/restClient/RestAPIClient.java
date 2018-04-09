package wallebit.sagishchori.com.wallebit.restClient;

import android.content.Context;

import wallebit.sagishchori.com.wallebit.dataManagers.AbstractDataManager;

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

    /**
     * A method to set the base URL for future calls.
     *
     * @param baseURL   The base URL (basic end point).
     *
     * @return          The RestAPIClient with the base URL assigned to it.
     */
    public static RestAPIClient setBaseURL(String baseURL)
    {
        restAPIClient.baseURL = baseURL;
        return restAPIClient;
    }

    /**
     * A method to set the query params for future calls.
     *
     * @param urlParams The query params as String to append to the baseUrl.
     *
     * @return          The RestAPIClient with the query params URL assigned to it.
     */
    public static RestAPIClient setURLParams(String urlParams)
    {
        restAPIClient.urlParams = urlParams;
        return restAPIClient;
    }

    /**
     * Get the full URL from baseUrl + urlParams.
     *
     * @return      The full URL from which the data is being fetched.
     */
    public String getFullURL()
    {
        return baseURL + urlParams;
    }

    /**
     * A method to start the task (with the help of AsyncTask.
     *
     * @param taskResponse      HttpTaskResponse interface to notify about the task stages.
     */
    public void execute(HttpTaskResponse taskResponse)
    {
        cancelGetTask();

        getTask = new HttpGetTask(getFullURL(), taskResponse, context);
        getTask.setDataManager(dataManager);
        getTask.execute(this);

    }

    /**
     * Cancel the task on-demand.
     */
    public void cancelGetTask()
    {
        if (getTask != null)
            getTask.cancel(true);
    }

    /**
     * A method to set DataManager.
     *
     * @param dataManager   The dataManager to assign
     */
    public void setDataManager(AbstractDataManager dataManager)
    {
        this.dataManager = dataManager;
    }
}
