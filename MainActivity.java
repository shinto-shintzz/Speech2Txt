package com.example.anonymous.speech2txt;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private static final int rec_examp=1;
    @Override
    //Overriding the onCreate
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        Button trigger = (Button) findViewById(R.id.trigger);
        trigger.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.ACTION_GET_LANGUAGE_DETAILS);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "SAY A WORD");
                startActivityForResult(intent,rec_examp);

            }
        });

    }

        @Override
                protected void onActivityResult(int requestCode,int resultCode,Intent data)
        {
            if(requestCode==rec_examp && resultCode==RESULT_OK)
            {
                ArrayList<String> result =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                tv.setText(result.toString());
            }
        }
    }


