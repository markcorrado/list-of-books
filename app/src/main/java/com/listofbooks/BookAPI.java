package com.listofbooks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by markcorrado on 10/15/17.
 */

public interface BookAPI {
    @GET("/books.json")
    Call<List<Book>> getBooks();
}
