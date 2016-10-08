package com.liyue.app.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        ListView myListView = (ListView)findViewById(R.id.myListView);
        final EditText myEditText = (EditText)findViewById(R.id.editText);

        final ArrayList<ToDoItem> todoItems = new ArrayList<ToDoItem>();
        final ArrayAdapter<ToDoItem> aa = new ArrayAdapter<ToDoItem>(this, R.layout.todolist_item,todoItems);
        myListView.setAdapter(aa);

        myEditText.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)){
                        todoItems.add(0, myEditText.getText().toString());
                        aa.notifyDataSetChanged();
                        myEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
