package wallebit.sagishchori.com.wallebit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import wallebit.sagishchori.com.wallebit.R;

public class LauncherActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);

        fetchAllCoinsData();
    }

    private void fetchAllCoinsData()
    {

    }
}
