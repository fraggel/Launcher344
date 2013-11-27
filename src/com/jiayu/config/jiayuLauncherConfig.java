package com.jiayu.config;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.android.launcher.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Fraggel on 16/11/13.
 */
public class jiayuLauncherConfig extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener,Spinner.OnItemSelectedListener {
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
    Spinner spinnerApps=null;
    HashMap<String,String> componentListPack = new HashMap<String, String>();
    HashMap<String,String> componentListPackName = new HashMap<String, String>();

    List<String> componentListString=new ArrayList<String>();
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
        spinnerApps=(Spinner) findViewById(R.id.spinnerApps);

        workspace_rows.setOnSeekBarChangeListener(this);
        workspace_cols.setOnSeekBarChangeListener(this);
        hotseat_icons.setOnSeekBarChangeListener(this);
        workspace_icons.setOnSeekBarChangeListener(this);

        allow_rotation.setOnCheckedChangeListener(this);
        show_google_bar.setOnCheckedChangeListener(this);
        show_customcontent.setOnCheckedChangeListener(this);
        spinnerApps.setOnItemSelectedListener(this);
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
            componentListString.clear();
            componentListPack.clear();
            componentListPackName.clear();
            workspace_rows.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_rows", 4));
            workspace_rows_text.setText(String.valueOf(workspace_rows.getProgress()));
            workspace_cols.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_cols", 4));
            workspace_cols_text.setText(String.valueOf(workspace_cols.getProgress()));
            hotseat_icons.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "hotseat_icons", 5));
            hotseat_icons_text.setText(calcularPercentString(hotseat_icons.getProgress()));
            workspace_icons.setProgress(Utils.getSharedPreferencesInt(getApplicationContext(), "workspace_icons", 5));
            workspace_icons_text.setText(calcularPercentString(workspace_icons.getProgress()));
            allow_rotation.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "allow_rotation", false));
            show_google_bar.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "show_google_bar", true));
            show_customcontent.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "show_customcontent", false));

            getInstalledComponentList();
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, componentListString);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerApps.setAdapter(dataAdapter3);
            spinnerApps.setEnabled(show_customcontent.isChecked());
            spinnerApps.setSelection(getSelected(Utils.getSharedPreferences(getApplicationContext(), "app_custom_contentName","Google")));
        }catch(Exception e){

        }
    }
    private void getInstalledComponentList()
            throws PackageManager.NameNotFoundException {
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> ril = getPackageManager().queryIntentActivities(mainIntent, 0);
        String name = null;
        for (ResolveInfo ri : ril) {
            if (ri.activityInfo != null) {
                Resources res = getPackageManager().getResourcesForApplication(ri.activityInfo.applicationInfo);
                if (ri.activityInfo.labelRes != 0) {
                    name = res.getString(ri.activityInfo.labelRes);
                } else {
                    name = ri.activityInfo.applicationInfo.loadLabel(
                            getPackageManager()).toString();
                }
                componentListPack.put(name,ri.activityInfo.packageName+"/"+ri.activityInfo.name);
                componentListPackName.put(ri.activityInfo.packageName+"/"+ri.activityInfo.name,name);
                componentListString.add(name);
            }
        }
        componentListString=reordenarLista(componentListString);
    }

    private String getPackageName(String nombreApp)
            throws PackageManager.NameNotFoundException {
        //recorrer el hashmap y ver el texto de ese package
        //al tener el nombre, buscar la posicion en el componentListString
        String s = componentListPack.get(nombreApp);
        return s;
    }
    private String getName(String nombrePackage)
            throws PackageManager.NameNotFoundException {
        //recorrer el hashmap y ver el texto de ese package
        //al tener el nombre, buscar la posicion en el componentListString
        String s = componentListPackName.get(nombrePackage);
        return s;
    }
    private int getSelected(String nombrePackage)
            throws PackageManager.NameNotFoundException {
        int id=-1;
        //String s = componentListPack.get(nombrePackage);
        id=componentListString.indexOf(nombrePackage);

        return id;
    }
    private List<String> reordenarLista(List<String> listaEntrada){
        Collections.sort(listaEntrada);
        return listaEntrada;
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
                spinnerApps.setEnabled(true);
            }else{
                show_customcontent.setChecked(false);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "show_customcontent", false);
                resetLauncher();
                spinnerApps.setEnabled(false);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        try {
            Utils.setSharedPreferences(getApplicationContext(), "app_custom_contentPackage",getPackageName(componentListString.get(position)));
            Utils.setSharedPreferences(getApplicationContext(), "app_custom_contentName",getName(getPackageName(componentListString.get(position))));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}