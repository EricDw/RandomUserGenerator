package com.publicmethod.owner.randomusergenerator.utils;

import com.publicmethod.owner.randomusergenerator.model.RandomUserResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * An Interface for interacting with
 * Created by Eric De Wildt on 2016-04-26.
 */
public interface RandomUserClient {


    @GET("api")
    Call<RandomUserResults> singleResultCall();

    @GET("api/")
    Call<RandomUserResults> multipleResultsCall(@Query("results") int results);

}
