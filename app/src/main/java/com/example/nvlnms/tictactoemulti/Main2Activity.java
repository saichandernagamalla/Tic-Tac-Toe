package com.example.nvlnms.tictactoemulti;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    int valArr[]=new int[9];
    int l=0;
    int turn=0;
    TextView t;
    final Button b[]=new Button[9];
    Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t=(TextView)findViewById(R.id.textView);

        b[0]=(Button)findViewById(R.id.button);
        b[1]=(Button)findViewById(R.id.button2);
        b[2]=(Button)findViewById(R.id.button3);
        b[3]=(Button)findViewById(R.id.button4);
        b[4]=(Button)findViewById(R.id.button5);
        b[5]=(Button)findViewById(R.id.button6);
        b[6]=(Button)findViewById(R.id.button7);
        b[7]=(Button)findViewById(R.id.button8);
        b[8]=(Button)findViewById(R.id.button9);
        reset=(Button)findViewById(R.id.button10);

        for(int i=0;i<9;i++)
            valArr[i]=-1;

        reset.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent();
                i.setClass(getBaseContext(),Main2Activity.class);
                startActivity(i);
            }
        });

        b[0].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[0], 0);
            }
        });
        b[1].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[1], 1);
            }
        });
        b[2].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[2], 2);
            }
        });
        b[3].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[3], 3);
            }
        });
        b[4].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[4], 4);
            }
        });
        b[5].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[5], 5);
            }
        });
        b[6].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[6], 6);
            }
        });
        b[7].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[7], 7);
            }
        });
        b[8].setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                my_fun(b[8], 8);
            }
        });
    }

    public void my_fun(Button b1,int pos)
    {
        if(turn%2==0 && valArr[pos]==-1 && l==0)
        {
            b1.setBackgroundResource(R.drawable.bc);
            valArr[pos]=0;
            turn++;

            if(turn==9)
            {
                Toast.makeText(getApplicationContext(),"it's a tie :(",Toast.LENGTH_LONG).show();
            }
            else if(turn%2==0 && l==0 && turn!=9)
                t.setText("player 1 turn");
            else if(turn%2==1 && l==0 && turn!=9)
                t.setText("player 2 turn");

            check(pos,turn);
        }
        else if(turn%2==1 && l==0 && valArr[pos]==-1)
        {
            b1.setBackgroundResource(R.drawable.cross1);
            valArr[pos]=1;
            turn++;

            if(turn==9)
            {
                Toast.makeText(getApplicationContext(),"it's a tie :(",Toast.LENGTH_LONG).show();
            }
            else if(turn%2==0)
                t.setText("player 1 turn");
            else t.setText("player 2 turn");
            check(pos,turn);
        }
    }

    public void onBackPressed(){
        Intent i =new Intent(this,home.class);
        ActivityOptions opt=ActivityOptions.makeCustomAnimation(getApplicationContext(),android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        startActivity(i,opt.toBundle());
    }

    public void check(int pos,int turn)
    {
        if(pos==4)
        {
            if((valArr[4]==valArr[3]&&valArr[4]==valArr[5])||(valArr[4]==valArr[1]&&valArr[4]==valArr[7])||(valArr[4]==valArr[0]&&valArr[4]==valArr[8])||(valArr[4]==valArr[2]&&valArr[4]==valArr[6])) {
                if (valArr[4] == 0){
                    t.setText("player 1 wins");
                }
                else
                    t.setText("player 2 wins");
                l++;

                if(valArr[4]==valArr[3]&&valArr[4]==valArr[5]){
                    if(valArr[4]==0) {
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[3].setBackgroundResource(R.drawable.greencircle);
                        b[5].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[3].setBackgroundResource(R.drawable.greencross);
                        b[5].setBackgroundResource(R.drawable.greencross);
                    }
                }

                if(valArr[4]==valArr[1]&&valArr[4]==valArr[7]){
                    if(valArr[4]==0) {
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[1].setBackgroundResource(R.drawable.greencircle);
                        b[7].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[1].setBackgroundResource(R.drawable.greencross);
                        b[7].setBackgroundResource(R.drawable.greencross);
                    }
                }

                if(valArr[4]==valArr[0]&&valArr[4]==valArr[0]){
                    if(valArr[4]==0) {
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[0].setBackgroundResource(R.drawable.greencircle);
                        b[8].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[0].setBackgroundResource(R.drawable.greencross);
                        b[8].setBackgroundResource(R.drawable.greencross);
                    }
                }
                if(valArr[4]==valArr[2]&&valArr[4]==valArr[6]){
                    if(valArr[4]==0) {
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[2].setBackgroundResource(R.drawable.greencircle);
                        b[6].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[2].setBackgroundResource(R.drawable.greencross);
                        b[6].setBackgroundResource(R.drawable.greencross);
                    }
                }
                //startActivity(i);
            }
        }
        else if(pos%2==1)
        {
            if(pos==1)
            {
                if((valArr[1]==valArr[0]&&valArr[1]==valArr[2])||(valArr[1]==valArr[4]&&valArr[1]==valArr[7])) {
                    if (valArr[1] == 0)
                        t.setText("player 1 wins");
                    else
                        t.setText("player 2 wins");
                    l++;
                    //startActivity(i);
                }

                if(valArr[1]==valArr[0]&&valArr[1]==valArr[2]){
                    if(valArr[1]==0) {
                        b[2].setBackgroundResource(R.drawable.greencircle);
                        b[1].setBackgroundResource(R.drawable.greencircle);
                        b[0].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[1].setBackgroundResource(R.drawable.greencross);
                        b[2].setBackgroundResource(R.drawable.greencross);
                        b[0].setBackgroundResource(R.drawable.greencross);
                    }
                }
                if(valArr[4]==valArr[1]&&valArr[1]==valArr[7]){
                    if(valArr[1]==0) {
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[1].setBackgroundResource(R.drawable.greencircle);
                        b[7].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[1].setBackgroundResource(R.drawable.greencross);
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[7].setBackgroundResource(R.drawable.greencross);
                    }
                }
            }
            else if(pos==3)
            {
                if((valArr[3]==valArr[0]&&valArr[3]==valArr[6])||(valArr[3]==valArr[4]&&valArr[3]==valArr[5])) {
                    if (valArr[3] == 0)
                        t.setText("player 1 wins");
                    else
                        t.setText("player 2 wins");
                    l++;

                }

                if(valArr[3]==valArr[0]&&valArr[3]==valArr[6]){
                    if(valArr[3]==0) {
                        b[0].setBackgroundResource(R.drawable.greencircle);
                        b[3].setBackgroundResource(R.drawable.greencircle);
                        b[6].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[0].setBackgroundResource(R.drawable.greencross);
                        b[3].setBackgroundResource(R.drawable.greencross);
                        b[6].setBackgroundResource(R.drawable.greencross);
                    }
                }

                if(valArr[4]==valArr[3]&&valArr[3]==valArr[5]){
                    if(valArr[3]==0) {
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[3].setBackgroundResource(R.drawable.greencircle);
                        b[5].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[3].setBackgroundResource(R.drawable.greencross);
                        b[5].setBackgroundResource(R.drawable.greencross);
                    }
                }
            }
            else if(pos==5)
            {
                if((valArr[5]==valArr[2]&&valArr[5]==valArr[8])||(valArr[5]==valArr[4]&&valArr[5]==valArr[3])) {
                    if (valArr[5] == 0)
                        t.setText("player 1 wins");
                    else
                        t.setText("player 2 wins");
                    l++;
                    //startActivity(i);
                }
                if(valArr[5]==valArr[2]&&valArr[5]==valArr[8]){
                    if(valArr[5]==0) {
                        b[8].setBackgroundResource(R.drawable.greencircle);
                        b[2].setBackgroundResource(R.drawable.greencircle);
                        b[5].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[8].setBackgroundResource(R.drawable.greencross);
                        b[2].setBackgroundResource(R.drawable.greencross);
                        b[5].setBackgroundResource(R.drawable.greencross);
                    }
                }
                if(valArr[4]==valArr[5]&&valArr[3]==valArr[5]){
                    if(valArr[5]==0) {
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[3].setBackgroundResource(R.drawable.greencircle);
                        b[5].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[3].setBackgroundResource(R.drawable.greencross);
                        b[5].setBackgroundResource(R.drawable.greencross);
                    }
                }

            }
            else if(pos==7)
            {
                if((valArr[7]==valArr[6]&&valArr[7]==valArr[8])||(valArr[7]==valArr[4]&&valArr[7]==valArr[1])) {
                    if (valArr[7] == 0)
                        t.setText("player 1 wins");
                    else
                        t.setText("player 2 wins");
                    l++;
                    //startActivity(i);
                }
                if(valArr[7]==valArr[6]&&valArr[7]==valArr[8]){
                    if(valArr[7]==0) {
                        b[7].setBackgroundResource(R.drawable.greencircle);
                        b[6].setBackgroundResource(R.drawable.greencircle);
                        b[8].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[7].setBackgroundResource(R.drawable.greencross);
                        b[6].setBackgroundResource(R.drawable.greencross);
                        b[8].setBackgroundResource(R.drawable.greencross);
                    }
                }
                if(valArr[7]==valArr[4]&&valArr[7]==valArr[1]){
                    if(valArr[7]==0) {
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[7].setBackgroundResource(R.drawable.greencircle);
                        b[1].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[7].setBackgroundResource(R.drawable.greencross);
                        b[1].setBackgroundResource(R.drawable.greencross);
                    }
                }
            }
        }
        else if(pos%2==0)
        {
            if(pos==0)
            {
                if((valArr[0]==valArr[1]&&valArr[0]==valArr[2])||(valArr[0]==valArr[3]&&valArr[0]==valArr[6])||(valArr[0]==valArr[4]&&valArr[0]==valArr[8])){
                    if (valArr[0] == 0)
                        t.setText("player 1 wins");
                    else
                        t.setText("player 2 wins");
                    l++;
                    //startActivity(i);
                }
                if(valArr[0]==valArr[1]&&valArr[0]==valArr[2]){
                    if(valArr[0]==0) {
                        b[0].setBackgroundResource(R.drawable.greencircle);
                        b[1].setBackgroundResource(R.drawable.greencircle);
                        b[2].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[0].setBackgroundResource(R.drawable.greencross);
                        b[1].setBackgroundResource(R.drawable.greencross);
                        b[2].setBackgroundResource(R.drawable.greencross);
                    }
                }
                if(valArr[0]==valArr[3]&&valArr[0]==valArr[6]){
                    if(valArr[0]==0) {
                        b[0].setBackgroundResource(R.drawable.greencircle);
                        b[3].setBackgroundResource(R.drawable.greencircle);
                        b[6].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[0].setBackgroundResource(R.drawable.greencross);
                        b[3].setBackgroundResource(R.drawable.greencross);
                        b[6].setBackgroundResource(R.drawable.greencross);
                    }
                }
                if(valArr[0]==valArr[4]&&valArr[0]==valArr[8]){
                    if(valArr[0]==0) {
                        b[0].setBackgroundResource(R.drawable.greencircle);
                        b[4].setBackgroundResource(R.drawable.greencircle);
                        b[8].setBackgroundResource(R.drawable.greencircle);
                    }
                    else{
                        b[0].setBackgroundResource(R.drawable.greencross);
                        b[4].setBackgroundResource(R.drawable.greencross);
                        b[8].setBackgroundResource(R.drawable.greencross);
                    }
                }
            }
            else if(pos==2)
            {
                if((valArr[2]==valArr[1]&&valArr[0]==valArr[2])||(valArr[2]==valArr[5]&&valArr[2]==valArr[8])||(valArr[2]==valArr[4]&&valArr[2]==valArr[6])){
                    if (valArr[2] == 0)
                        t.setText("player 1 wins");
                    else
                        t.setText("player 2 wins");
                    l++;
                    //startActivity(i);
                    if(valArr[2]==valArr[1]&&valArr[0]==valArr[2]){
                        if(valArr[2]==0) {
                            b[0].setBackgroundResource(R.drawable.greencircle);
                            b[1].setBackgroundResource(R.drawable.greencircle);
                            b[2].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[0].setBackgroundResource(R.drawable.greencross);
                            b[1].setBackgroundResource(R.drawable.greencross);
                            b[2].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                    if(valArr[2]==valArr[5]&&valArr[2]==valArr[8]){
                        if(valArr[2]==0) {
                            b[2].setBackgroundResource(R.drawable.greencircle);
                            b[5].setBackgroundResource(R.drawable.greencircle);
                            b[8].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[2].setBackgroundResource(R.drawable.greencross);
                            b[5].setBackgroundResource(R.drawable.greencross);
                            b[8].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                    if(valArr[2]==valArr[4]&&valArr[2]==valArr[6]){
                        if(valArr[2]==0) {
                            b[2].setBackgroundResource(R.drawable.greencircle);
                            b[4].setBackgroundResource(R.drawable.greencircle);
                            b[6].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[2].setBackgroundResource(R.drawable.greencross);
                            b[4].setBackgroundResource(R.drawable.greencross);
                            b[6].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                }
            }
            else if(pos==6)
            {
                if((valArr[6]==valArr[0]&&valArr[6]==valArr[3])||(valArr[6]==valArr[7]&&valArr[6]==valArr[8])||(valArr[6]==valArr[4]&&valArr[6]==valArr[2])){
                    if (valArr[6] == 0)
                        t.setText("player 1 wins");
                    else
                        t.setText("player 2 wins");
                    l++;
                    //startActivity(i);
                    if(valArr[6]==valArr[0]&&valArr[6]==valArr[3]){
                        if(valArr[6]==0) {
                            b[0].setBackgroundResource(R.drawable.greencircle);
                            b[6].setBackgroundResource(R.drawable.greencircle);
                            b[3].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[0].setBackgroundResource(R.drawable.greencross);
                            b[6].setBackgroundResource(R.drawable.greencross);
                            b[3].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                    if(valArr[6]==valArr[7]&&valArr[6]==valArr[8]){
                        if(valArr[6]==0) {
                            b[6].setBackgroundResource(R.drawable.greencircle);
                            b[7].setBackgroundResource(R.drawable.greencircle);
                            b[8].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[6].setBackgroundResource(R.drawable.greencross);
                            b[7].setBackgroundResource(R.drawable.greencross);
                            b[8].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                    if(valArr[6]==valArr[4]&&valArr[6]==valArr[2]){
                        if(valArr[6]==0) {
                            b[6].setBackgroundResource(R.drawable.greencircle);
                            b[4].setBackgroundResource(R.drawable.greencircle);
                            b[2].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[6].setBackgroundResource(R.drawable.greencross);
                            b[4].setBackgroundResource(R.drawable.greencross);
                            b[2].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                }
            }else if(pos==8) {
                if ((valArr[8] == valArr[6] && valArr[8] == valArr[7]) || (valArr[8] == valArr[5] && valArr[8] == valArr[2]) || (valArr[8] == valArr[4] && valArr[8] == valArr[0])) {
                    if (valArr[8] == 0)
                        t.setText("player 1 wins");
                    else
                        t.setText("player 2 wins");
                    l++;
                    //startActivity(i);
                    if(valArr[8]==valArr[6]&&valArr[8]==valArr[7]){
                        if(valArr[8]==0) {
                            b[8].setBackgroundResource(R.drawable.greencircle);
                            b[6].setBackgroundResource(R.drawable.greencircle);
                            b[7].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[8].setBackgroundResource(R.drawable.greencross);
                            b[6].setBackgroundResource(R.drawable.greencross);
                            b[7].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                    if(valArr[8]==valArr[5]&&valArr[8]==valArr[2]){
                        if(valArr[8]==0) {
                            b[8].setBackgroundResource(R.drawable.greencircle);
                            b[5].setBackgroundResource(R.drawable.greencircle);
                            b[2].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[8].setBackgroundResource(R.drawable.greencross);
                            b[5].setBackgroundResource(R.drawable.greencross);
                            b[2].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                    if(valArr[8]==valArr[4]&&valArr[0]==valArr[8]){
                        if(valArr[8]==0) {
                            b[0].setBackgroundResource(R.drawable.greencircle);
                            b[4].setBackgroundResource(R.drawable.greencircle);
                            b[8].setBackgroundResource(R.drawable.greencircle);
                        }
                        else{
                            b[0].setBackgroundResource(R.drawable.greencross);
                            b[4].setBackgroundResource(R.drawable.greencross);
                            b[8].setBackgroundResource(R.drawable.greencross);
                        }
                    }
                }
            }
        }
    }
}