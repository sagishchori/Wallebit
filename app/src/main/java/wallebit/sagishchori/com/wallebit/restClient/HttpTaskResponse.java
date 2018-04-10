package wallebit.sagishchori.com.wallebit.restClient;

public interface HttpTaskResponse<T>
{
    /**
     * A method to notify when the task completed.
     *
     * @param object    The object to pass when the task is completed.
     */
    void onTaskCompleted(T object);

    /**
     * A method to notify when task failed to complete.
     */
    void onTaskFailed();
}
