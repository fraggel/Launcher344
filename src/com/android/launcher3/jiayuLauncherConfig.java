package com.android.launcher3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Fraggel on 16/11/13.
 */
public class jiayuLauncherConfig extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    SeekBar s1 =null;
    SeekBar s2 =null;
    SeekBar s3 =null;
    SeekBar s4=null;
    TextView t1=null;
    TextView t2=null;
    TextView t3=null;
    TextView t4=null;
    Switch sw1=null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiayu_launcher_config);
        s1 =(SeekBar)findViewById(R.id.seekBar);
        s2 =(SeekBar)findViewById(R.id.seekBar2);
        s3 =(SeekBar)findViewById(R.id.seekBar3);
        s4 =(SeekBar)findViewById(R.id.seekBar4);
        t1 =(TextView)findViewById(R.id.textView3);
        t2 =(TextView)findViewById(R.id.textView4);
        t3 =(TextView)findViewById(R.id.textView6);
        t4 =(TextView)findViewById(R.id.textView7);
        sw1 =(Switch) findViewById(R.id.switch1);

        s1.setOnSeekBarChangeListener(this);
        s2.setOnSeekBarChangeListener(this);
        s3.setOnSeekBarChangeListener(this);
        s4.setOnSeekBarChangeListener(this);
        sw1.setOnCheckedChangeListener(this);

        Button b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(this);
        initValues();
    }

    private void initValues() {
        try {
            sw1.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "allow_rotation", false));

        }catch(Exception e){

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if(seekBar.getId()==R.id.seekBar){
               t1.setText(String.valueOf(progress));
            }else if(seekBar.getId()==R.id.seekBar2){
                t2.setText(String.valueOf(progress));
            }else if(seekBar.getId()==R.id.seekBar3){
                int percent=0;
                if(progress==0){
                    percent=50;
                }
                if(progress==1){
                    percent=75;
                }
                if(progress==2){
                    percent=100;
                }
                if(progress==3){
                    percent=125;
                }
                if(progress==4){
                    percent=150;
                }
                t4.setText(String.valueOf(percent)+"%");

            }else if(seekBar.getId()==R.id.seekBar4){
                t3.setText(String.valueOf(progress));
            }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.getId()==R.id.switch1){
            if(isChecked){
                sw1.setChecked(true);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "allow_rotation", true);
            }else{
                sw1.setChecked(false);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "allow_rotation", false);
            }

        }else if(buttonView.getId()==R.id.switch2){

        }

    }
    public void resetLauncher(){
        System.exit(0);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        resetLauncher();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}