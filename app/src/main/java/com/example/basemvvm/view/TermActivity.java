package com.example.basemvvm.view;

import android.os.Bundle;

import com.example.basemvvm.R;

public class TermActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        setupHeader("TERM");
    }
}
