package wallebit.sagishchori.com.wallebit.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionUtils
{
    /**
     * A method to know if there is a connectivity.
     *
     * @param       {@param context}.
     * @return      true - if connected, false - if not connected.
     */
    public static boolean isOnLine(Context context)
    {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        return info != null && info.isConnected() && (info.getType() == ConnectivityManager.TYPE_MOBILE || info.getType() == ConnectivityManager.TYPE_WIFI);
    }
}
