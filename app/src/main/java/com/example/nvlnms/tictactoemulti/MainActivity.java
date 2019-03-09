package com.example.nvlnms.tictactoemulti;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int filled=0;
    int valArr[]=new int[9];
    int l=0,fillCount=0;
    int turn=0,t1=0;
    TextView t;
    final Button b[]=new Button[9];
    Button reset;
    int first=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Random r=new Random();
        first=r.nextInt(2);

        reset.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent();
                i.setClass(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });

        if(first==1)
        {
            my_fun(b[0],0);
        }

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

    public void onBackPressed(){
        Intent i =new Intent(this,home.class);
        ActivityOptions opt=ActivityOptions.makeCustomAnimation(getApplicationContext(),android.R.anim.fade_in,android.R.anim.fade_out);
        startActivity(i,opt.toBundle());
    }

    public void my_fun(Button b1,int pos) {
        int temp=0;
        if (turn == 9 && l == 0)
            t.setText("its a tie!!!");

        if (first == 1) {
            Random r = new Random();
            int p = r.nextInt(9);
            b[p].setBackgroundResource(R.drawable.cross1);
            valArr[p] = 1;
            filled++;
            //turn++;
            first = -1;

        }
        else {
            if (turn % 2 == 0 && valArr[pos] == -1 && l == 0) {
                b1.setBackgroundResource(R.drawable.bc);
                valArr[pos] = 0;
                filled++;
                turn++;

                if (filled == 1 && (pos == 0 || pos == 2 || pos == 6 || pos == 8))
                    t1 = 1;
                if (turn % 2 == 1 && l == 0 && turn != 9)
                    t.setText("cpu turn");

                else if ((turn == 9 && l == 0)||(turn==8 && first==-1)) {
                    t.setText("it's a tie!!!");
                    Toast.makeText(getApplicationContext(), "it's a tie :(", Toast.LENGTH_LONG).show();

                }

                check(pos, turn);
            }

            if (turn % 2 == 1 && l == 0) {
                Random r = new Random();
                int p = r.nextInt(9);

                if (filled == 1 && valArr[4] == 0) {
                    while (p != 0 || p != 2 || p != 6 || p != 8) {
                        if (valArr[p] == -1 && (p == 0 || p == 2 || p == 6 || p == 8))
                            break;
                        p = r.nextInt(9);
                    }
                    valArr[p] = 1;
                    b[p].setBackgroundResource(R.drawable.cross1);
                    turn++;
                    filled++;temp=1;
                } else if (filled == 1 && (valArr[0] == 0 || valArr[2] == 0 || valArr[6] == 0 || valArr[8] == 0)) {
                    int p1 = 0;
                    if(first==1){
                        if (valArr[0] == 0)
                            p1 = 8;
                        else if (valArr[2] == 0)
                            p1 = 6;
                        else if (valArr[6] == 0)
                            p1 = 2;
                        else if (valArr[8] == 0)
                            p1 = 0;

                        valArr[p1] = 1;
                        b[p1].setBackgroundResource(R.drawable.cross1);
                    }
                    else{
                        valArr[4]=1;
                        b[4].setBackgroundResource(R.drawable.cross1);
                    }
                    turn++;
                    filled++;
                    temp=1;
                }

                else if (filled == 3 && (valArr[4] == 0 && (valArr[0] == 1 || valArr[2] == 1 || valArr[6] == 1 || valArr[8] == 1)) && t1 == 1) {
                    int p1 = 0;
                    if (valArr[0] == 1)
                        p1 = 2;
                    else if (valArr[2] == 1)
                        p1 = 0;
                    else if (valArr[6] == 1)
                        p1 = 8;
                    else if (valArr[8] == 1)
                        p1 = 6;

                    valArr[p1] = 1;
                    b[p1].setBackgroundResource(R.drawable.cross1);
                    turn++;
                    filled++;temp=1;
                }
                else if(filled==3 && first==0 && valArr[4]==1 && (valArr[0] == 0 || valArr[2] == 0 || valArr[6] == 0 || valArr[8] == 0))
                {
                    if(valArr[0]==valArr[2] && valArr[0]!=-1) {
                        valArr[1] = 1;
                        b[3].setBackgroundResource(R.drawable.cross1);turn++;
                        filled++;
                    }
                    else if(valArr[0]==valArr[6] && valArr[0]!=-1)
                    {
                        valArr[3] = 1;
                        b[3].setBackgroundResource(R.drawable.cross1);turn++;
                        filled++;
                    }
                    else if(valArr[6]==valArr[8] && valArr[6]!=-1)
                    {
                        valArr[7] = 1;
                        b[7].setBackgroundResource(R.drawable.cross1);turn++;
                        filled++;
                    }
                    else if(valArr[8]==valArr[2] && valArr[8]!=-1)
                    {
                        valArr[5] = 1;
                        b[5].setBackgroundResource(R.drawable.cross1);turn++;
                        filled++;
                    }
                    else if((valArr[0]!=-1 && (valArr[0]==valArr[8])) || ((valArr[2]==valArr[6]) && valArr[6]!=-1)){
                        valArr[3]=1;
                        b[3].setBackgroundResource(R.drawable.cross1);
                        temp=1;
                        turn++;
                        filled++;
                    }

                }
                else if (filled == 3 && valArr[4] == -1 && t1 == 0) {
                    valArr[4] = 1;
                    b[4].setBackgroundResource(R.drawable.cross1);
                    turn++;
                    filled++;temp=1;
                }
                else if (filled == 1 && (valArr[1] == 0 || valArr[3] == 0 || valArr[5] == 0 || valArr[7] == 0)) {
                    /*if (valArr[1] == 0) {
                        int p1 = r.nextInt(5);
                        while (p1 % 2 != 0)
                            p1 = r.nextInt(5);
                        valArr[p1] = 1;
                        b[p1].setBackgroundResource(R.drawable.cross1);
                        turn++;
                        filled++;
                    } else if (valArr[3] == 0) {
                        int p1 = r.nextInt(7);
                        while (true) {
                            if (p1 == 0 || p1 == 4 || p1 == 6)
                                break;
                            p1 = r.nextInt(7);
                        }
                        valArr[p1] = 1;
                        b[p1].setBackgroundResource(R.drawable.cross1);
                        turn++;
                        filled++;
                    } else if (valArr[5] == 0) {
                        int p1 = r.nextInt(9);
                        while (true) {
                            if (p1 == 2 || p1 == 4 || p1 == 8)
                                break;
                            p1 = r.nextInt(9);
                        }
                        valArr[p1] = 1;
                        b[p1].setBackgroundResource(R.drawable.cross1);
                        turn++;
                        filled++;
                    } else if (valArr[7] == 0) {
                        int p1 = r.nextInt(9);
                        while (true) {
                            if (p1 == 4 || p1 == 6 || p1 == 8)
                                break;
                            p1 = r.nextInt(9);
                        }
                        valArr[p1] = 1;
                        b[p1].setBackgroundResource(R.drawable.cross1);
                        turn++;
                        filled++;
                    }*/
                    valArr[4]=1;
                    b[4].setBackgroundResource(R.drawable.cross1);
                    turn++;
                    filled++;
                    temp=1;
                }
                else if (filled == 1) {
                    while (valArr[p] != -1)
                        p = r.nextInt(9);
                    filled++;
                    b[p].setBackgroundResource(R.drawable.cross1);
                    turn++;
                    valArr[p] = 1;
                    temp=1;
                    //Toast.makeText(getApplicationContext(), "expected", Toast.LENGTH_SHORT).show();
                }
                if(temp==0 && turn%2==1) {
                    //check for cpu win
                    for (int i = 0; i < 9; i++) {
                        if (valArr[i] == -1) {
                            int[] copiedArray = Arrays.copyOf(valArr, valArr.length);
                            copiedArray[i] = 1;
                            if (checkForWin(copiedArray, i) == 1) {
                                b[i].setBackgroundResource(R.drawable.cross1);
                                t.setText("computer wins!!!");
                                Toast.makeText(getApplicationContext(), "computer wins!!!", Toast.LENGTH_LONG).show();
                                turn++;
                                valArr[i] = 1;
                                filled++;
                                l = 1;
                                check(i, turn);
                                //return;
                                break;
                            }
                        }
                    }

                    //check whether your move will help opponent win.
                    if (l == 0 && turn%2==1) {
                        int ch = 0;
                        for (int i = 0; i < 9; i++) {
                            if (valArr[i] == -1) {
                                int j = 0;
                                for (j = 0; j < 9; j++) {
                                    int[] copiedArray = Arrays.copyOf(valArr, valArr.length);
                                    copiedArray[i] = 1;
                                    if (copiedArray[j] == -1) {
                                        copiedArray[j] = 0;
                                        if (checkForWin(copiedArray, j) == 1)
                                            break;
                                    }
                                }
                                if (j == 9) {
                                    valArr[i] = 1;
                                    b[i].setBackgroundResource(R.drawable.cross1);
                                    turn++;
                                    filled++;
                                    ch = 1;
                                    break;
                                }
                            }
                        }
                        if (ch == 0 && turn < 9) {
                            while (valArr[p] != -1)
                                p = r.nextInt(9);
                            filled++;
                            b[p].setBackgroundResource(R.drawable.cross1);
                            turn++;
                            valArr[p] = 1;
                        }
                    }
                }
                if (turn % 2 == 0 && l ==0)
                    t.setText("player 1 turn");

                else if (turn == 9 && l == 0) {
                    Toast.makeText(getApplicationContext(), "it's a tie :(", Toast.LENGTH_LONG).show();
                }
                //check(p,turn);
                if(turn==8 && first==-1 && l==0)
                {
                    t.setText("its a tie");
                    Toast.makeText(getApplicationContext(),"its a tie",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public int checkForWin(int a[],int pos)
    {
        if(pos==4)
        {
            if((a[4]==a[3]&&a[4]==a[5])||(a[4]==a[1]&&a[4]==a[7])||(a[4]==a[0]&&a[4]==a[8])||(a[4]==a[2]&&a[4]==a[6])) {
                return 1;
            }
        }
        else if(pos%2==1)
        {
            if(pos==1)
            {
                if((a[1]==a[0]&&a[1]==a[2])||(a[1]==a[4]&&a[1]==a[7])) {
                    return 1;
                }
            }
            else if(pos==3)
            {
                if((a[3]==a[0]&&a[3]==a[6])||(a[3]==a[4]&&a[3]==a[5])) {
                    return 1;
                }
            }
            else if(pos==5)
            {
                if((a[5]==a[2]&&a[5]==a[8])||(a[5]==a[4]&&a[5]==a[3])) {
                    return 1;
                }
            }
            else if(pos==7)
            {
                if((a[7]==a[6]&&a[7]==a[8])||(a[7]==a[4]&&a[7]==a[1])) {
                    return 1;
                }
            }
        }
        else if(pos%2==0)
        {
            if(pos==0)
            {
                if((a[0]==a[1]&&a[0]==a[2])||(a[0]==a[3]&&a[0]==a[6])||(a[0]==a[4]&&a[0]==a[8])){
                    return 1;
                }
            }
            else if(pos==2)
            {
                if((a[2]==a[1]&&a[0]==a[2])||(a[2]==a[5]&&a[2]==a[8])||(a[2]==a[4]&&a[2]==a[6])){
                    return 1;
                }
            }
            else if(pos==6)
            {
                if((a[6]==a[0]&&a[6]==a[3])||(a[6]==a[7]&&a[6]==a[8])||(a[6]==a[4]&&a[6]==a[2])){
                    return 1;
                }
            }else if(pos==8) {
                if ((a[8] == a[6] && a[8] == a[7]) || (a[8] == a[5] && a[8] == a[2]) || (a[8] == a[4] && a[8] == a[0])) {
                    return 1;
                }
            }
        }
        return 0;
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