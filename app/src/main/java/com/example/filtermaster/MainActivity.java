package com.example.filtermaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items, filteredList;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        filteredList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText searchEdt = (EditText)findViewById(R.id.searchEdt);

        adapter = new RecyclerViewAdapter(items, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        items.add(new Item("히어로"));
        items.add(new Item("다크나이트"));
        items.add(new Item("호영"));
        items.add(new Item("일리움"));
        items.add(new Item("패스파인더"));
        items.add(new Item("와일드헌터"));
        items.add(new Item("듀얼블레이더"));
        items.add(new Item("캐논슈터"));
        items.add(new Item("카인"));
        items.add(new Item("팔라딘"));
        items.add(new Item("라딘딘"));
        items.add(new Item("히어로1111"));
        adapter.notifyDataSetChanged();

        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String searchText = searchET.getText().toString();
                searchFilter(searchText);
            }
        });
    }
}