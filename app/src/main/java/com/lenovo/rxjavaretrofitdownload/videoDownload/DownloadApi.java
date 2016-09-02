package com.lenovo.rxjavaretrofitdownload.videoDownload;

import com.lenovo.rxjavaretrofitdownload.common.AppConstant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * songwenju on 16-8-23 : 16 : 32.
 * 邮箱：songwenju@outlook.com
 */
public class DownloadApi extends BaseApi{
    //单例的DownloadApi
    private static DownloadApi mDownloadApi = new DownloadApi();
    private DownloadService mDownloadService;

    public static DownloadApi getInstance(){
        return mDownloadApi;
    }

    private DownloadApi(){
        Retrofit retrofit = new  Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(AppConstant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mDownloadService = retrofit.create(DownloadService.class);
    }

    public DownloadService getDownloadService() {
        return mDownloadService;
    }
}
