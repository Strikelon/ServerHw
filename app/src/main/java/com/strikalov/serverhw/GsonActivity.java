package com.strikalov.serverhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "MyLogger";

    private static final String MESSAGE = " {\"time_of_year\": \"summer\", \"year\": 2019}";

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        ButterKnife.bind(this);

        gson = new Gson();
    }

    @OnClick(R.id.run_button)
    void onClickRunButton(){
        Log.i(TAG, "onClickRunButton");
        YearPogo yearPogo = gson.fromJson(MESSAGE, YearPogo.class);
        Log.i(TAG, yearPogo.toString());
    }

}
