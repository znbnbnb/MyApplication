package com.znb.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cort);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                    startActivity(new Intent(Main2Activity.this,MainActivity.class));
////                                ToastUtils.showToast(Main2Activity.this,"action");
//                                  startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                            }
                        }).show();
//                SnackbarUtil.ShortSnackbar(coordinatorLayout,"test",SnackbarUtil.Confirm);
            }
        });
    }

}
