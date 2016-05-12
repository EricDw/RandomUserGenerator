package com.publicmethod.owner.randomusergenerator.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eric De Wildt on 2016-04-27.
 */
public class ServiceGenerator {

    private static OkHttpClient.Builder httpsClientBuilder = new OkHttpClient.Builder();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.RANDOM_USER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <T> T createService(Class<T> serviceClass){
        Retrofit retrofit = retrofitBuilder.client(httpsClientBuilder.build())
                .build();
        return retrofit.create(serviceClass);
    }
}
