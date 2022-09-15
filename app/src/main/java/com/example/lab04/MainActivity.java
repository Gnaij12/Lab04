package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    int layoutNum;
    ConstraintLayout layout;
    int[] layoutArray;
    int[] ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        layoutNum = 0;
        layoutArray = new int[]{R.layout.layout1,R.layout.layout2,R.layout.layout3,R.layout.layout4,R.layout.layout5,R.layout.layout6,R.layout.layout7};
        ids = new int[]{R.id.layout1,R.id.layout2,R.id.layout3,R.id.layout4,R.id.layout5,R.id.layout6,R.id.layout7};
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            layoutNum = (++layoutNum)%layoutArray.length;
            setContentView(layoutArray[layoutNum]);
        }
        return true;
    }

    public void randomize(View view) {
        int prevLayoutNum = layoutNum;
        layoutNum = (int)(Math.random()*7);
        setContentView(layoutArray[layoutNum]);
        Snackbar snackbar = Snackbar.make(findViewById(ids[layoutNum]),"Layout changed to layout " + (layoutNum+1),Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutNum = prevLayoutNum;
                setContentView(layoutArray[layoutNum]);
            }
        });
        snackbar.setActionTextColor(Color.MAGENTA);
        View snackBarView = snackbar.getView();
        TextView textView = snackBarView.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }
}