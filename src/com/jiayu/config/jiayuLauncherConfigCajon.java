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
public class jiayuLauncherConfigCajon extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener{

    TextView allapps_transparency_text=null;
    SeekBar allapps_transparency=null;
    SeekBar allapps_rows =null;
    SeekBar allapps_cols =null;
    SeekBar allapps_icons=null;
    SeekBar widgets_rows =null;
    SeekBar widgets_cols =null;
    TextView widgets_rows_text=null;
    TextView widgets_cols_text=null;
    TextView allapps_rows_text=null;
    TextView allapps_cols_text=null;
    TextView allapps_icons_text=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiayu_launcher_config_cajon);

        allapps_rows =(SeekBar)findViewById(R.id.allapps_rows);
        allapps_cols =(SeekBar)findViewById(R.id.allapps_cols);
        allapps_icons =(SeekBar)findViewById(R.id.allapps_icons);

        widgets_rows =(SeekBar)findViewById(R.id.widgets_rows);
        widgets_cols =(SeekBar)findViewById(R.id.widgets_cols);

        widgets_rows_text =(TextView)findViewById(R.id.widgets_rows_text);
        widgets_cols_text =(TextView)findViewById(R.id.widgets_cols_text);

        allapps_rows_text =(TextView)findViewById(R.id.allapps_rows_text);
        allapps_cols_text =(TextView)findViewById(R.id.allapps_cols_text);
        allapps_icons_text =(TextView)findViewById(R.id.allapps_icons_text);

        allapps_transparency_text=(TextView)findViewById(R.id.txtTransparencyApps);
        allapps_transparency=(SeekBar)findViewById(R.id.transparencyApps);

        allapps_rows.setOnSeekBarChangeListener(this);
        allapps_cols.setOnSeekBarChangeListener(this);
        allapps_icons.setOnSeekBarChangeListener(this);
        allapps_transparency.setOnSeekBarChangeListener(this);

        widgets_rows.setOnSeekBarChangeListener(this);
        widgets_cols.setOnSeekBarChangeListener(this);

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

            allapps_rows.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "allapps_rows", getResources().getInteger(R.integer.allapps_rows)));
            allapps_rows_text.setText(String.valueOf(allapps_rows.getProgress()));
            allapps_cols.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "allapps_cols", getResources().getInteger(R.integer.allapps_cols)));
            allapps_cols_text.setText(String.valueOf(allapps_cols.getProgress()));
            allapps_icons.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "allapps_icons", getResources().getInteger(R.integer.allapps_icons)));
            allapps_icons_text.setText(calcularPercentString(allapps_icons.getProgress()));

            allapps_transparency.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "allapps_transparency", R.color.transparent10));
            allapps_transparency_text.setText(calcularPercent0100(allapps_transparency.getProgress()));

            widgets_rows.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "widgets_rows", getResources().getInteger(R.integer.widgets_rows)));
            widgets_rows_text.setText(String.valueOf(widgets_rows.getProgress()));
            widgets_cols.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "widgets_cols", getResources().getInteger(R.integer.widgets_cols)));
            widgets_cols_text.setText(String.valueOf(widgets_cols.getProgress()));


        }catch(Exception e){

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if(seekBar.getId()==R.id.allapps_rows){
                if(progress<1){
                    progress=1;
                }
                Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_rows", progress);
                allapps_rows_text.setText(String.valueOf(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.allapps_cols){
                if(progress<1){
                    progress=1;
                }
                Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_cols", progress);
                allapps_cols_text.setText(String.valueOf(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.widgets_rows){
                if(progress<1){
                    progress=1;
                }
                Utils.setSharedPreferencesInt(getApplicationContext(), "widgets_rows", progress);
                widgets_rows_text.setText(String.valueOf(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.widgets_cols){
                if(progress<1){
                    progress=1;
                }
                Utils.setSharedPreferencesInt(getApplicationContext(), "widgets_cols", progress);
                widgets_cols_text.setText(String.valueOf(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.transparencyApps){
                if(progress<0){
                    progress=0;
                }
                Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency", progress);
                switch(progress){
                    case 0:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent0);
                        break;
                    case 1:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent1);
                        break;
                    case 2:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent2);
                        break;
                    case 3:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent3);
                        break;
                    case 4:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent4);
                        break;
                    case 5:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent5);
                        break;
                    case 6:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent6);
                        break;
                    case 7:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent7);
                        break;
                    case 8:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent8);
                        break;
                    case 9:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent9);
                        break;
                    case 10:
                        Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_transparency_color", R.color.transparent10);
                        break;
                }


                allapps_transparency_text.setText(calcularPercent0100(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.allapps_icons){
                Utils.setSharedPreferencesInt(getApplicationContext(), "allapps_icons", progress);
                allapps_icons_text.setText(calcularPercentString(progress));
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