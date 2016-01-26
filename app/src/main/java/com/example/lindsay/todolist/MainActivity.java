package com.example.lindsay.todolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        items.add("Tell Mom you love her");
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items);
        ListView list = (ListView) findViewById(R.id.to_do_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    public void addItem(View view) {
        Button button = (Button) findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(), "Item added.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListView list = (ListView) findViewById(R.id.to_do_list);
        String item = list.getItemAtPosition(position).toString();
        Toast.makeText(this, "You clicked " + item, Toast.LENGTH_SHORT).show();
        items.remove(position);
        adapter.notifyDataSetChanged();
    }
}
