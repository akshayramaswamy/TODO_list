package com.example.akshayramaswamy.cs193a_hw2_aramaswa;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private static final ArrayList<String> list_items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        // put the to-do list words into an Adapter so they can be seen in ListView
        ListView list = (ListView) findViewById(R.id.TODO_list);
        adapter = new ArrayAdapter<>(
                this,                                        // activity
               android.R.layout.simple_list_item_1,         // layout,
                list_items// array
        );
        list.setAdapter(adapter);

        //create on click listener to remove words from list
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                list_items.remove(word);
                adapter.notifyDataSetChanged();

            }
        });

    }


    public void addItem(View view) {

        TextView enteredItem = (TextView) findViewById(R.id.newItem);
        list_items.add(enteredItem.getText().toString());
        adapter.notifyDataSetChanged();
        enteredItem.setText("");

    }
}
