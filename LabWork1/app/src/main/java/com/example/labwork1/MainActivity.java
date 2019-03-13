package com.example.labwork1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecycleViewCustomAdapter recycleViewCustomAdapter;
    private static final String RecAdapterPosition = "RecycleViewCustomAdapterPosition";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleViewCustomAdapter = new RecycleViewCustomAdapter(this, 1000000);
        recyclerView = new RecyclerView(this);

        recyclerView.setAdapter(recycleViewCustomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
        setContentView(recyclerView);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(RecAdapterPosition, ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        recyclerView.scrollToPosition(savedInstanceState.getInt(RecAdapterPosition));
    }
}