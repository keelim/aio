package com.keelim.aio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class OpenView extends RecyclerView {
    Context context;


    public OpenView(Context context, OpenRecyclerAdapter adapter) {
        super(context);
        this.context = getContext();

        initView();
    }

    public OpenView(Context context, AttributeSet attrs, OpenRecyclerAdapter adapter) {
        super(context, attrs);
        this.context = getContext();

        initView();
        getAttrs(attrs);
    }

    public OpenView(Context context, AttributeSet attrs, int defStyle, OpenRecyclerAdapter adapter) {
        super(context, attrs);
        this.context = getContext();
        initView();
        getAttrs(attrs, defStyle);
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.view_recycler, this, false);
        addView(v);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.OpenView);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.OpenView, defStyle, 0);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {
//        int bg_resID = typedArray.getResourceId(R.styleable.LoginButton_bg, R.drawable.login_naver_bg);
//        bg.setBackgroundResource(bg_resID);
//        int symbol_resID = typedArray.getResourceId(R.styleable.LoginButton_symbol, R.drawable.login_naver_symbol);
//        symbol.setImageResource(symbol_resID);
//        int textColor = typedArray.getColor(R.styleable.LoginButton_textColor, 0);
//        text1.setTextColor(textColor);
//        String text_string = typedArray.getString(R.styleable.LoginButton_text);
//        text1.setText(text_string);
//        typedArray.recycle();
    }

    void setLayout(int bg_resID) {
//        bg.setBackgroundResource(bg_resID);
    }

    void setSymbol(int symbol_resID) {
//        symbol.setImageResource(symbol_resID);
    }

    void setTextColor(int color) {
//        text1.setTextColor(color);
    }

    void setText1(String text_string) {
//        text1.setText(text_string);
    }

    void setText(int text_resID) {
//        text1.setText(text_resID);
    }

    public void render(OpenRecyclerAdapter adapter) {
        this.setLayoutManager(new LinearLayoutManager(getContext()));
        this.setAdapter(adapter);
    }
}

