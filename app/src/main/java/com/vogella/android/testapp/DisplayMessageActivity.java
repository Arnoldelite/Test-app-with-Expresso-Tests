package com.vogella.android.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "is Extremely Awesome";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null)
        .show();
        }
        });
        */

        //Bundle intent = getIntent().getExtras();
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //String message = intent.getString("EXTRA_MESSAGE");
        String message2 = message +" "+ EXTRA_MESSAGE;
        TextView textView = (TextView) findViewById(R.id.display);
        textView.setTextSize(40);
        textView.setText(message2);

        //RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        //layout.addView(textView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }





}
