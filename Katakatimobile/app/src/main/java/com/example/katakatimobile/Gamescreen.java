package com.example.katakatimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Gamescreen extends AppCompatActivity {
    int activeplayer=0;
    int position[]={2,2,2,2,2,2,2,2,2};
    int winposition[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int count=0;
   boolean game=true;
    public void playerclick(View view) {
        if(count==8)
        {   Toast.makeText(this, "Game Drawn!", Toast.LENGTH_SHORT).show();
            count=0;
            reset(view);
        return;}
        ImageView image = (ImageView) view;
        int cell = Integer.parseInt(image.getTag().toString());
        image.setTranslationY(-1000f);



        if (activeplayer == 0&&position[cell]==2) {
            position[cell] = activeplayer;
            activeplayer = 1;
            count++;
            image.setImageResource(R.drawable.xpng);
            TextView xturn = findViewById(R.id.textView2);
            xturn.setText("'O' Turn -Play");

        } else if (activeplayer == 1&&position[cell]==2)
        {  position[cell] = activeplayer;
            activeplayer = 0;
            count++;
            image.setImageResource(R.drawable.opng);
            TextView xturn = findViewById(R.id.textView2);
            xturn.setText("'X' Turn -Play");
        }
        image.animate().translationYBy(1000f).setDuration(300);
        for (int[] winposisons : winposition) {
            if ((position[winposisons[0]] == position[winposisons[1]]) && (position[winposisons[1]] == position[winposisons[2]]) && position[winposisons[1]] != 2)

            {
                if (activeplayer == 0) {
                    Intent intent = getIntent();
                    String winner = intent.getStringExtra("splayer");
                    Toast.makeText(this, "" + winner + " Wins!", Toast.LENGTH_SHORT).show();
                    game=false;
                    reset(view);
                }
                if (activeplayer == 1) {
                    Intent intent = getIntent();
                    String winner = intent.getStringExtra("fplayer");
                    Toast.makeText(this, "" + winner + " Wins!", Toast.LENGTH_SHORT).show();
                    game=false;
                    reset(view);
                }
            }
        }
    }
    public void reset(View view)
    {  game=true;
    int i;
    for(i=0;i<position.length;i++)
        position[i]=2;
    activeplayer=0;
        ((ImageView)findViewById(R.id.x1)).setImageResource(0);
        ((ImageView)findViewById(R.id.x2)).setImageResource(0);
        ((ImageView)findViewById(R.id.x3)).setImageResource(0);
        ((ImageView)findViewById(R.id.x4)).setImageResource(0);
        ((ImageView)findViewById(R.id.x5)).setImageResource(0);
        ((ImageView)findViewById(R.id.x6)).setImageResource(0);
        ((ImageView)findViewById(R.id.x7)).setImageResource(0);
        ((ImageView)findViewById(R.id.x8)).setImageResource(0);
        ((ImageView)findViewById(R.id.x9)).setImageResource(0);
        TextView xturn = findViewById(R.id.textView2);
        xturn.setText("'X' Turn -Play");
        count=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamescreen);
    }
}
