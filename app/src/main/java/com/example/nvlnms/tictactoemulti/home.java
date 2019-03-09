package com.example.nvlnms.tictactoemulti;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        b1=(Button)findViewById(R.id.button11);
        b2=(Button)findViewById(R.id.button12);

        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                ActivityOptions opt=ActivityOptions.makeCustomAnimation(getApplicationContext(),android.R.anim.fade_in,android.R.anim.fade_out);
                startActivity(i,opt.toBundle());
            }
        });

        b2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                ActivityOptions opt=ActivityOptions.makeCustomAnimation(getApplicationContext(),android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                startActivity(i,opt.toBundle());
            }
        });
    }
    public void onBackPressed(){
        Intent i =new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
