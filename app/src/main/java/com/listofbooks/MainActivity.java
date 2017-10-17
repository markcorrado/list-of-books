package com.listofbooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<List<Book>> {


    RecyclerView recyclerView;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BookAdapter();
        recyclerView.setAdapter(adapter);
        BookAPI bookAPI = BookService.getInstance().getBookAPI();
        Call<List<Book>> call = bookAPI.getBooks();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
        adapter.setBooks(response.body());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Call<List<Book>> call, Throwable t) {
        Toast.makeText(getApplicationContext(), "Oops, something went wrong.", Toast.LENGTH_SHORT).show();
    }
}
