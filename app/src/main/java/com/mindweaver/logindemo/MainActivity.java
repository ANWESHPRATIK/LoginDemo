package com.mindweaver.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText Password;
    Button button;
    TextView info;
    int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.name);
        Password=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.loginbutton);
        info=(TextView)findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),Password.getText().toString());
            }
        });

    }

    protected void validate(String username, String Password){

        if(username.equals("admin")&& Password.equals("1234")){
            Intent in=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(in); }
        else{
            counter--;
            info.setText("No. of attempts remaining:"+String.valueOf(counter));

            if(counter==0){
                button.setEnabled(false);
            }
        }


    }
}
