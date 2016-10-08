package com.liyue.app.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by luli01 on 2016/9/29.
 */

public class ToDoListItemView extends TextView {
    public ToDoListItemView(Context context, AttributeSet ats, int ds){
        super(context, ats, ds);
        init();
    }

    public ToDoListItemView(Context context){
        super(context);
        init();
    }

    public ToDoListItemView(Context context, AttributeSet ats){
        super(context, ats);
        init();
    }

    private void init(){
        Resources myResource = getResources();
        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResource.getColor(R.color.notepad_margin));
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResource.getColor(R.color.notepad_lines));

        paperColor = myResource.getColor(R.color.notepad_paper);
        margin = myResource.getDimension(R.dimen.notepad_margin);
    }

    @Override
    public void onDraw(Canvas canvas){
        canvas.drawColor(paperColor);
        canvas.drawLine(0,0,0,getMeasuredHeight(),linePaint);
        canvas.drawLine(0,getMeasuredHeight(),getMeasuredWidth(),getMeasuredHeight(),linePaint);
        canvas.drawLine(margin,0,margin,getMeasuredHeight(),marginPaint);
        canvas.save();
        canvas.translate(margin,0);
        super.onDraw(canvas);
        canvas.restore();
    }

    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;
}
