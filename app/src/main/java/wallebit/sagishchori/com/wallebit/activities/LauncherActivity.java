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
import wallebit.sagishchori.com.wallebit.utils.ConnectionUtils;

public class LauncherActivity extends AppCompatActivity
{
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
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(LauncherActivity.this, "An error occurred while fetching the data", Toast.LENGTH_LONG).show();
                        new Timer().schedule(new TimerTask()
                        {
                            @Override
                            public void run()
                            {
                                finish();
                            }
                        }, 4000);
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        if (coinDataManager != null)
        {
            coinDataManager.close();
        }

        super.onDestroy();
    }
}
