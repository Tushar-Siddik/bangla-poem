package com.android.microsoft.design;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {

    TextView poemTitle, poetName, poemBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.color.imageBackground);

        poemTitle = (TextView) findViewById(R.id.poemTitle);
        poetName = (TextView) findViewById(R.id.poetName);
        poemBody = (TextView) findViewById(R.id.poemBody);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("PoemTitle");
            if(value != null)
                poemTitle.setText(value);
            JSONReader.getPoemByPoet(this,value);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
