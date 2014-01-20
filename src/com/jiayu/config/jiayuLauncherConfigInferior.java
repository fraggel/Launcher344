package com.jiayu.config;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.launcher.R;

/**
 * Created by Fraggel on 16/11/13.
 */
public class jiayuLauncherConfigInferior extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    SeekBar hotseat_icons=null;

    TextView hotseat_icons_text=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiayu_launcher_config_inferior);
        hotseat_icons =(SeekBar)findViewById(R.id.hotseat_icons);
        hotseat_icons_text =(TextView)findViewById(R.id.hotseat_icons_text);
        hotseat_icons.setOnSeekBarChangeListener(this);

        initValues();
    }

    @Override
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        initValues();
    }

    private void initValues() {
        try {
            hotseat_icons.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "hotseat_icons", 7));
            hotseat_icons_text.setText(calcularPercentString(hotseat_icons.getProgress()));

        }catch(Exception e){

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if(seekBar.getId()==R.id.hotseat_icons){
                Utils.setSharedPreferencesInt(getApplicationContext(), "hotseat_icons", progress);
                hotseat_icons_text.setText(calcularPercentString(progress));
                resetLauncher();
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
    protected void onDestroy() {
        super.onDestroy();
    }

    private void resetLauncher() {
        Utils.setSharedPreferencesBoolean(getApplicationContext(), "need_restart", true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public String calcularPercentString(int progress){
        int percent=0;
        if(progress==0){
            percent=75;
        }
        if(progress==1){
            percent=80;
        }
        if(progress==2){
            percent=85;
        }
        if(progress==3){
            percent=90;
        }
        if(progress==4){
            percent=95;
        }
        if(progress==5){
            percent=100;
        }
        if(progress==6){
            percent=105;
        }
        if(progress==7){
            percent=110;
        }
        if(progress==8){
            percent=115;
        }
        if(progress==9){
            percent=120;
        }
        if(progress==10){
            percent=125;
        }
        if(progress==11){
            percent=130;
        }
        if(progress==12){
            percent=135;
        }
        if(progress==13){
            percent=140;
        }
        if(progress==14){
            percent=145;
        }
        if(progress==15){
            percent=150;
        }
        if(progress==16){
            percent=155;
        }
        if(progress==17){
            percent=160;
        }
        return String.valueOf(percent)+"%";
    }
    public String calcularPercent0100(int progress){
        int percent=0;
        if(progress==0){
            percent=0;
        }
        if(progress==1){
            percent=10;
        }
        if(progress==2){
            percent=20;
        }
        if(progress==3){
            percent=30;
        }
        if(progress==4){
            percent=40;
        }
        if(progress==5){
            percent=50;
        }
        if(progress==6){
            percent=60;
        }
        if(progress==7){
            percent=70;
        }
        if(progress==8){
            percent=80;
        }
        if(progress==9){
            percent=90;
        }
        if(progress==10){
            percent=100;
        }
        return String.valueOf(percent)+"%";
    }
    public static int calcularPercentFormula(int progress){
        int percent=0;
        if(progress==0){
            percent=75;
        }
        if(progress==1){
            percent=80;
        }
        if(progress==2){
            percent=85;
        }
        if(progress==3){
            percent=90;
        }
        if(progress==4){
            percent=95;
        }
        if(progress==5){
            percent=100;
        }
        if(progress==6){
            percent=105;
        }
        if(progress==7){
            percent=110;
        }
        if(progress==8){
            percent=115;
        }
        if(progress==9){
            percent=120;
        }
        if(progress==10){
            percent=125;
        }
        if(progress==11){
            percent=130;
        }
        if(progress==12){
            percent=135;
        }
        if(progress==13){
            percent=140;
        }
        if(progress==14){
            percent=145;
        }
        if(progress==15){
            percent=150;
        }
        if(progress==16){
            percent=155;
        }
        if(progress==17){
            percent=160;
        }
        return percent;
    }
}