package com.strikalov.serverhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetorfitActivity extends AppCompatActivity {

    private static final String TAG = "MyLogger";
    private static final String URL_REQUEST = "https://api.github.com/";
    private static final String JAKEWHARTON = "JakeWharton";

    private Disposable disposable;

    @BindView(R.id.avatar_image)
    ImageView avatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retorfit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.download_button)
    void onClickDownloadButton(){
        Log.i(TAG, "onClickDownloadButton()");
        WebApiService webApiService = getWebApiService();
        disposable = webApiService.loadAvatar(JAKEWHARTON)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        avatarPogo -> Picasso.get()
                                    .load(avatarPogo.getAvatarUrl())
                                    .into(avatarImage),

                        throwable -> Log.i(TAG, throwable.toString())
                );
    }

    private WebApiService getWebApiService(){

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(URL_REQUEST)
                .build();

        return  retrofit.create(WebApiService.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(disposable != null){
            disposable.dispose();
        }
    }
}
