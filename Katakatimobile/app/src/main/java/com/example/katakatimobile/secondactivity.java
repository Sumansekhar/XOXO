package com.example.katakatimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity  {
    EditText fname;
    EditText sname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_secondactivity);
    }




    public void playstarter(View v) {
        fname = findViewById(R.id.Firstplayernaam);
        sname = findViewById(R.id.Secondplayernaam);
        String f1=fname.getText().toString().trim();
        String s1=sname.getText().toString().trim();
                if(v.getId()==R.id.button3)
                if (f1 != null && !f1.isEmpty() && !f1.equals("null")&&s1!=null&&!s1.isEmpty()&&!s1.equals("null"))
                { Intent intent=new Intent(secondactivity.this,Gamescreen.class);
                 intent.putExtra("fplayer",f1);
                 intent.putExtra("splayer",s1);
                startActivity(intent);}
                else
                    Toast.makeText(this, "Enter Player Name", Toast.LENGTH_SHORT).show();
        }
    }

