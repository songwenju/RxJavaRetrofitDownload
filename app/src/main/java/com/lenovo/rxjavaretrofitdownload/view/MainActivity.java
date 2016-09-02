package com.lenovo.rxjavaretrofitdownload.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lenovo.downloaddemo.R;
import com.lenovo.rxjavaretrofitdownload.common.AppConstant;
import com.lenovo.rxjavaretrofitdownload.util.LogUtil;
import com.lenovo.rxjavaretrofitdownload.videoDownload.DownloadApi;
import com.lenovo.rxjavaretrofitdownload.videoDownload.WriteFileManager;
import com.lenovo.rxjavaretrofitdownload.videoDownload.DownloadService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private DownloadService mDownloadService;
    private List<String> mDownloadList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadApi downloadApi = DownloadApi.getInstance();
        mDownloadService = downloadApi.getDownloadService();
        final String downloadUrl1 = AppConstant.DOWNLOAD_URL1;
        final String downloadUrl2 = AppConstant.DOWNLOAD_URL2;
        final String downloadUrl3 = AppConstant.DOWNLOAD_URL3;

        mDownloadList = new ArrayList<>();
        mDownloadList.add(downloadUrl1);
        mDownloadList.add(downloadUrl2);
        mDownloadList.add(downloadUrl3);
    }

    /**
     * 多线程下载
     * @param view view
     */
    public void download(View view) {
        LogUtil.i(this, "MainActivity.download.");

        List<Observable<Boolean>> observables = new ArrayList<Observable<Boolean>>();
        //将所有的Observable放到List中
        for (int i = 0; i < mDownloadList.size(); i++) {
            final String downloadUrl = mDownloadList.get(i);
            observables.add(mDownloadService.downloadFile(downloadUrl)
                    .subscribeOn(Schedulers.io())
                    .map(new Func1<ResponseBody, Boolean>() {
                        @Override
                        public Boolean call(ResponseBody responseBody) {
                            return WriteFileManager.writeResponseBodyToDisk(responseBody, downloadUrl);
                        }
                    }).subscribeOn(Schedulers.io()));
        }

        //Observable的merge将所有的Observable合成一个Observable,所有的observable同时发射数据。
        Observable.merge(observables).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Boolean b) {
                        if (b) {
                            Toast.makeText(MainActivity.this, "Download is sucess", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
