package com.jiayu.config;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import com.android.launcher.R;
import com.android.launcher2.*;

/**
 * Created by Fraggel on 16/11/13.
 */
public class jiayuLauncherConfig extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    SeekBar workspace_rows =null;
    SeekBar workspace_cols =null;
    SeekBar hotseat_icons=null;
    SeekBar workspace_icons=null;
    TextView workspace_rows_text=null;
    TextView workspace_cols_text=null;
    TextView hotseat_icons_text=null;
    TextView workspace_icons_text=null;
    Switch allow_rotation=null;
    Switch show_google_bar=null;
    Switch show_customcontent=null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiayu_launcher_config);
        workspace_rows =(SeekBar)findViewById(R.id.workspace_rows);
        workspace_cols =(SeekBar)findViewById(R.id.workspace_cols);
        hotseat_icons =(SeekBar)findViewById(R.id.hotseat_icons);
        workspace_icons=(SeekBar)findViewById(R.id.workspace_icons);

        workspace_rows_text =(TextView)findViewById(R.id.workspace_rows_text);
        workspace_cols_text =(TextView)findViewById(R.id.workspace_cols_text);
        hotseat_icons_text =(TextView)findViewById(R.id.hotseat_icons_text);
        workspace_icons_text=(TextView)findViewById(R.id.workspace_icons_text);

        allow_rotation =(Switch) findViewById(R.id.allow_rotation);
        show_google_bar =(Switch) findViewById(R.id.show_google_bar);
        show_customcontent =(Switch) findViewById(R.id.show_customcontent);

        workspace_rows.setOnSeekBarChangeListener(this);
        workspace_cols.setOnSeekBarChangeListener(this);
        hotseat_icons.setOnSeekBarChangeListener(this);
        workspace_icons.setOnSeekBarChangeListener(this);

        allow_rotation.setOnCheckedChangeListener(this);
        show_google_bar.setOnCheckedChangeListener(this);
        show_customcontent.setOnCheckedChangeListener(this);
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
            workspace_rows.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_rows", 4));
            workspace_rows_text.setText(String.valueOf(workspace_rows.getProgress()));
            workspace_cols.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_cols", 4));
            workspace_cols_text.setText(String.valueOf(workspace_cols.getProgress()));
            hotseat_icons.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "hotseat_icons", 2));
            hotseat_icons_text.setText(calcularPercentString(hotseat_icons.getProgress()));
            workspace_icons.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_icons", 2));
            workspace_icons_text.setText(calcularPercentString(workspace_icons.getProgress()));
            allow_rotation.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "allow_rotation", false));
            show_google_bar.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "show_google_bar", true));
            show_customcontent.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "show_customcontent", false));

        }catch(Exception e){

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if(seekBar.getId()==R.id.workspace_rows){
                Utils.setSharedPreferencesInt(getApplicationContext(), "workspace_rows", progress);
                workspace_rows_text.setText(String.valueOf(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.workspace_cols){
                Utils.setSharedPreferencesInt(getApplicationContext(), "workspace_cols", progress);
                workspace_cols_text.setText(String.valueOf(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.workspace_icons){
                Utils.setSharedPreferencesInt(getApplicationContext(), "workspace_icons", progress);
                workspace_icons_text.setText(calcularPercentString(progress));
                resetLauncher();
            }else if(seekBar.getId()==R.id.hotseat_icons){
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
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.getId()==R.id.allow_rotation){
            if(isChecked){
                allow_rotation.setChecked(true);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "allow_rotation", true);
                resetLauncher();
            }else{
                allow_rotation.setChecked(false);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "allow_rotation", false);
                resetLauncher();
            }

        }else if(buttonView.getId()==R.id.show_google_bar){
            if(isChecked){
                show_google_bar.setChecked(true);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "show_google_bar", true);
                resetLauncher();
            }else{
                show_google_bar.setChecked(false);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "show_google_bar", false);
                resetLauncher();
            }
        }
        else if(buttonView.getId()==R.id.show_customcontent){
            if(isChecked){
                show_customcontent.setChecked(true);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "show_customcontent", true);
                resetLauncher();
            }else{
                show_customcontent.setChecked(false);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "show_customcontent", false);
                resetLauncher();
            }
        }

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
        return String.valueOf(percent)+"%";
    }
    public static int calcularPercentFormula(int progress){
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
        return percent;
    }
}