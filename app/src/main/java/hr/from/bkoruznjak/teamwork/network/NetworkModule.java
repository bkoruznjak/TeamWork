package hr.from.bkoruznjak.teamwork.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import hr.from.bkoruznjak.teamwork.root.AppScope;
import hr.from.bkoruznjak.teamwork.root.TeamWorkApp;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bkoruznjak on 27/09/2017.
 */
@Module
public class NetworkModule {

    String mBaseUrl;
    String mUsername;
    String mPassword;

    public NetworkModule(String baseUrl, String username, String password) {
        this.mBaseUrl = baseUrl;
        this.mUsername = username;
        this.mPassword = password;
    }

    @Provides
    @AppScope
    public Cache provideOkHttpCache(TeamWorkApp application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @AppScope
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @AppScope
    @Named("standardClient")
    public OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new BasicAuthInterceptor(mUsername, mPassword))
                .build();
        return client;
    }

    @Provides
    @AppScope
    @Named("debugClient")
    public OkHttpClient provideLoggingkHttpClient(Cache cache) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new BasicAuthInterceptor(mUsername, mPassword))
                .build();
        return client;
    }

    @Provides
    @AppScope
    @Named("sixtySecondTimeoutClient")
    public OkHttpClient provideLongTimeoutOkHttpClient(Cache cache) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new BasicAuthInterceptor(mUsername, mPassword))
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        return client;
    }

    @Provides
    @AppScope
    @Named("simpleRetrofit")
    public Retrofit provideRetrofit(Gson gson, @Named("standardClient") OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @AppScope
    @Named("debugRetrofit")
    public Retrofit provideDebugRetrofit(Gson gson, @Named("debugClient") OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @AppScope
    @Named("simpleWebApi")
    public TeamWebApi providesSimpleWebApi(@Named("simpleRetrofit") Retrofit retrofit) {
        return retrofit.create(TeamWebApi.class);
    }


    @Provides
    @AppScope
    @Named("debugWebApi")
    public TeamWebApi providesDebugWebApi(@Named("debugRetrofit") Retrofit retrofit) {
        return retrofit.create(TeamWebApi.class);
    }
}