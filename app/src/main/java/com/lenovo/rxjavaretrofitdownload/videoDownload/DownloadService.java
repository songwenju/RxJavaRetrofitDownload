package com.lenovo.rxjavaretrofitdownload.videoDownload;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * songwenju on 16-8-23 : 16 : 32.
 * 邮箱：songwenju@outlook.com
 */
public interface DownloadService {
   @Streaming
   @GET
   Observable<ResponseBody> downloadFile(@Url String fileUrl);
}
