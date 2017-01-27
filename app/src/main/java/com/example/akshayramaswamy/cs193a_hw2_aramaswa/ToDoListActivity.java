/*
 * Akshay Ramaswamy <aramaswa@stanford.edu>
 * CS 193A, Winter 2017
 * Homework Assignment 2
 * TO DO List  - This app asks the user to input an item for their to do list,
 * and displays the item on the screen. If the user clicks on the item, it removes
 * the item from the list
 */
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


import static com.example.akshayramaswamy.cs193a_hw2_aramaswa.R.id.text;

public class ToDoListActivity extends AppCompatActivity {

    /* Instance vars */
    private ArrayAdapter<String> adapter;
    private static final ArrayList<String> list_items = new ArrayList<>();

    /* Method: onCreate
     * This method is called when the app boots up, and creates a customized ListView to which we add
     * items from the to do list. We also create an on click listener that executed when an item in the list
     * is clicked. The list item that was clicked is then removed from the array list and the UI is updated
     * to reflect the changes.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        // put the to-do list words into an Adapter so they can be seen in ListView
        ListView list = (ListView) findViewById(R.id.TODO_list);
        adapter = new ArrayAdapter<>(
                this,
                R.layout.row_item, //custom XML
                R.id.Itemname,
                list_items
        );

        list.setAdapter(adapter);

        //create on click listener to remove words from list
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                list_items.remove(word);
                adapter.notifyDataSetChanged(); //update UI

            }
        });

    }

    /* Method: addItem
     * This method is called when the user clicks the Add button.
     * The text in the text box next to the button is then added to the To Do list, and the UI is updated.
     * We reset the text after the changes.
     */
    public void addItem(View view)  {
        TextView enteredItem = (TextView) findViewById(R.id.newItem);
        list_items.add(enteredItem.getText().toString());
        adapter.notifyDataSetChanged(); //update UI
        enteredItem.setText("");

    }
}
