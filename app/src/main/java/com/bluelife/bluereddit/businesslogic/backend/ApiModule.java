package com.bluelife.bluereddit.businesslogic.backend;

import com.bluelife.bluereddit.BuildConfig;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.LoggingMode;
import net.dean.jraw.http.OkHttpAdapter;
import net.dean.jraw.http.UserAgent;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/**
 * Created by HiWin10 on 3/25/2017.
 */

@Module
public class ApiModule {

    private static final int LIMIT_COUNT=3;
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    OkHttpAdapter provideOkHttpAdapter(OkHttpClient client){
        return new OkHttpAdapter(client, Protocol.SPDY_3);
    }

    @Provides
    RedditClient provideRedditClient(OkHttpAdapter adapter){
        RedditClient redditClient=new RedditClient(
                UserAgent.of(BuildConfig.APPLICATION_ID + BuildConfig.VERSION_NAME), adapter);
        redditClient.setRetryLimit(LIMIT_COUNT);
        redditClient.setLoggingMode(LoggingMode.ALWAYS);
        return redditClient;
    }



}
