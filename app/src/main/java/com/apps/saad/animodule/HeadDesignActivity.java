package com.apps.saad.animodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HeadDesignActivity extends AppCompatActivity {
    Button main,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_design);
        next();
    }

    private void next(){
        main = (Button) findViewById(R.id.main);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HeadDesignActivity.this, SubMainActivity.class);
                startActivity(myIntent);
            }
        });
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HeadDesignActivity.this, ElephantDesignActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
