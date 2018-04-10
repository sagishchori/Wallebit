package wallebit.sagishchori.com.wallebit.dataManagers;

public abstract class AbstractDataManager<T>
{
    /**
     * A generic method to save data gotten from web services.
     *
     * @param data  The {@param data} object to be saved.
     */
    public abstract void saveData(T data);
}
