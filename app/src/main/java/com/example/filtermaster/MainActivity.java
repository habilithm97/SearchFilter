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

    private ArrayList<MainModel> items, filteredList;
    private RecyclerViewAdapter adapter;

    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        items = new ArrayList<>();
        filteredList = new ArrayList<>(); // 필터링된 리스트

        edt = (EditText)findViewById(R.id.edt);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(items, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        items.add(new MainModel("소곱창구이"));
        items.add(new MainModel("곱창볶음"));
        items.add(new MainModel("피자"));
        items.add(new MainModel("수제버거"));
        items.add(new MainModel("떡볶이"));
        items.add(new MainModel("후라이드치킨"));
        items.add(new MainModel("순대국밥"));
        items.add(new MainModel("반반피자"));
        items.add(new MainModel("양념치킨"));
        items.add(new MainModel("돼지국밥"));
        items.add(new MainModel("연어회"));
        items.add(new MainModel("광어회"));
        items.add(new MainModel("삼겹살"));
        items.add(new MainModel("양꼬치"));
        adapter.notifyDataSetChanged();

        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 입력하기 전에 처리
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 입력과 동시에 처리
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 입력 후에 처리
                String str = edt.getText().toString();
                searchFilter(str);
            }
        });
    }


    public void searchFilter(String str) {
        filteredList.clear(); // 필터링된 리스트를 비우고

        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().toLowerCase().contains(str.toLowerCase())) { // 입력한 문자열과 일치하는 아이템이면
                filteredList.add(items.get(i)); // 필터링된 리스트에 추가
            }
        }
        adapter.filterList(filteredList); // 어댑터의 filterList()를 호출해서 필터링된 리스트를 파라미터로 전달
    }
}