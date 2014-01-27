package com.jiayu.config;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.fraggel.launcher.R;

/**
 * Created by Fraggel on 16/11/13.
 */
public class jiayuLauncherConfigEscritorio extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    SeekBar workspace_rows =null;
    SeekBar workspace_cols =null;

    SeekBar workspace_icons=null;
    TextView workspace_rows_text=null;
    TextView workspace_cols_text=null;

    TextView workspace_icons_text=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiayu_launcher_config_escritorio);
        workspace_rows =(SeekBar)findViewById(R.id.workspace_rows);
        workspace_cols =(SeekBar)findViewById(R.id.workspace_cols);

        workspace_icons=(SeekBar)findViewById(R.id.workspace_icons);

        workspace_rows_text =(TextView)findViewById(R.id.workspace_rows_text);
        workspace_cols_text =(TextView)findViewById(R.id.workspace_cols_text);

        workspace_icons_text=(TextView)findViewById(R.id.workspace_icons_text);

        workspace_rows_text =(TextView)findViewById(R.id.workspace_rows_text);
        workspace_cols_text =(TextView)findViewById(R.id.workspace_cols_text);

        workspace_icons_text=(TextView)findViewById(R.id.workspace_icons_text);

        workspace_rows.setOnSeekBarChangeListener(this);
        workspace_cols.setOnSeekBarChangeListener(this);

        workspace_icons.setOnSeekBarChangeListener(this);

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

            workspace_rows.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_rows", 5));
            workspace_rows_text.setText(String.valueOf(workspace_rows.getProgress()));
            workspace_cols.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_cols", 5));
            workspace_cols_text.setText(String.valueOf(workspace_cols.getProgress()));

            workspace_icons.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_icons", 10));
            workspace_icons_text.setText(calcularPercentString(workspace_icons.getProgress()));

        }catch(Exception e){

        }
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if(seekBar.getId()==R.id.workspace_rows){
                if(progress<1){
                    progress=1;
                }
                Utils.setSharedPreferencesInt(getApplicationContext(), "workspace_rows", progress);
                workspace_rows_text.setText(String.valueOf(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.workspace_cols){
                if(progress<1){
                    progress=1;
                }
                Utils.setSharedPreferencesInt(getApplicationContext(), "workspace_cols", progress);
                workspace_cols_text.setText(String.valueOf(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.workspace_icons){
                Utils.setSharedPreferencesInt(getApplicationContext(), "workspace_icons", progress);
                workspace_icons_text.setText(calcularPercentString(progress));
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