package wallebit.sagishchori.com.wallebit.restClient;

public interface HttpTaskResponse<T>
{
    void onTaskCompleted(T object);

    void onTaskFailed();
}
