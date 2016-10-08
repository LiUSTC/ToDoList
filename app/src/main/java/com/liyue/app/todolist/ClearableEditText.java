package com.liyue.app.todolist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by luli01 on 2016/9/30.
 */

public class ClearableEditText extends LinearLayout {
    EditText editText;
    Button clearButton;

    public ClearableEditText(Context context){
        super(context);
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.clearable_edit_text,this,true);

        editText = (EditText)findViewById(R.id.editText);
        clearButton = (Button)findViewById(R.id.clearButton);

        hookupButton();
    }

    public ClearableEditText(Context context, AttributeSet ats, int ds){
        super(context, ats, ds);
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.clearable_edit_text,this,true);

        editText = (EditText)findViewById(R.id.editText);
        clearButton = (Button)findViewById(R.id.clearButton);

        hookupButton();
    }

    public ClearableEditText(Context context, AttributeSet ats){
        super(context, ats);
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.clearable_edit_text,this,true);

        editText = (EditText)findViewById(R.id.editText);
        clearButton = (Button)findViewById(R.id.clearButton);

        hookupButton();
    }

    private void hookupButton(){
        clearButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                editText.setText("");
            }
        });
    }
}
