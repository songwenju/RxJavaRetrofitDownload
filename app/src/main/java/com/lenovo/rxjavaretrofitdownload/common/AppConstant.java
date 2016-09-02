package com.lenovo.rxjavaretrofitdownload.common;

/**
 * songwenju on 16-8-19 : 10 : 29.
 * 邮箱：songwenju@outlook.com
 */
public class AppConstant {

    public static final String BASE_URL = "http://10.103.222.122:8080/";
    public static final String DOWNLOAD_URL1 = "protein.mp4";
    public static final String DOWNLOAD_URL2 = "chess.mp4";
    public static final String DOWNLOAD_URL3 = "mvp.wmv";

    //okHttp超时时间
    public final static int CONNECT_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 100;
    public final static int WRITE_TIMEOUT = 60; //设置读取超时为100秒
}
