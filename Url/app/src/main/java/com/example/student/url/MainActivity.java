package com.example.student.url;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private  Button button;
    private EditText edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);
        edittext= (EditText) findViewById(R.id.edittext);
        button= (Button) findViewById(R.id.linkbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if (edittext.getText().toString().startsWith("http://")){
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(edittext.getText().toString()));
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+edittext.getText().toString()));
                    startActivity(intent);}

                }
               catch (ActivityNotFoundException e ){
                   Toast.makeText(MainActivity.this,"BROWSER", Toast.LENGTH_SHORT).show();

               }

            }
        });
    }
}

