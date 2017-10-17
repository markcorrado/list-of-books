package com.listofbooks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by markcorrado on 10/17/17.
 */

public class BookService {
    private static BookService instance;
    public static final String URL = "http://de-coding-test.s3.amazonaws.com/";

    private BookAPI bookAPI;

    public static BookService getInstance(){
        if(instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    private BookService() {
        buildServices();
    }

    private void buildServices(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.bookAPI = retrofit.create(BookAPI.class);
    }

    public BookAPI getBookAPI() {
        return this.bookAPI;
    }
}
