package wallebit.sagishchori.com.wallebit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import wallebit.sagishchori.com.wallebit.R;
import wallebit.sagishchori.com.wallebit.dataManagers.CoinDataManager;
import wallebit.sagishchori.com.wallebit.restClient.HttpTaskResponse;

public class LauncherActivity extends AppCompatActivity
{
    /**
     * Time delay in millisecond.
     */
    private static final int CLOSING_APP_DELAY = 4000;

    private CoinDataManager coinDataManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        fetchAllCoinsData();
    }

    private void startMainCurrencyListActivity()
    {
        Intent intent = new Intent(this, MainCurrencyListActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Initial call to fetch all coins' data when each time launching the Application.
     */
    private void fetchAllCoinsData()
    {
        coinDataManager = CoinDataManager.getInstance(getApplicationContext());
        coinDataManager.getAllCoinsDataList(false, new HttpTaskResponse<String>()
        {
            @Override
            public void onTaskCompleted(String object)
            {
                startMainCurrencyListActivity();
            }

            @Override
            public void onTaskFailed()
            {
                // In case fetching the data fails, notify the user (on the UI thread) and close the App.
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        // Hide the {@link ProgressBar}.
                        progressBar.setVisibility(View.INVISIBLE);

                        // Show the error message to the user.
                        Toast.makeText(LauncherActivity.this, getResources().getString(R.string.error_fetching_data), Toast.LENGTH_LONG).show();

                        // Start Timer to close the App.
                        new Timer().schedule(new TimerTask()
                        {
                            @Override
                            public void run()
                            {
                                finish();
                            }
                        }, CLOSING_APP_DELAY);
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        if (coinDataManager != null)
            coinDataManager.close();

        super.onDestroy();
    }
}
