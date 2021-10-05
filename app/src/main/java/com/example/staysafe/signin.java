package com.example.staysafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signin extends AppCompatActivity {
    Button signIn;
    Button login1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signIn= findViewById(R.id.btnsign);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });


        login1= findViewById(R.id.btnlogin1);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),login.class);
                startActivity(i);
            }
        });
    }
}