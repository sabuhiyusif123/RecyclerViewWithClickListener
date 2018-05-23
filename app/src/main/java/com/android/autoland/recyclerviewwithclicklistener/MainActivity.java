package com.android.autoland.recyclerviewwithclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener{
    List<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItems();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this, strings);

        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(RecyclerViewAdapter.ItemHolder item, int position) {
        Toast.makeText(this, item.vDebtAmount.getText()  + ": " + position, Toast.LENGTH_SHORT).show();
    }

    public void addItems() {
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
        strings.add("dasadas");
    }
}
