package com.jiayu.config;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.fraggel.launcher.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Fraggel on 16/11/13.
 */
public class jiayuLauncherConfigGeneral extends Activity implements  View.OnClickListener, CompoundButton.OnCheckedChangeListener,Spinner.OnItemSelectedListener {
    Switch allow_rotation=null;
    Switch show_google_bar=null;
    Switch show_customcontent=null;

    Spinner spinnerApps=null;
    HashMap<String,String> componentListPack = new HashMap<String, String>();
    HashMap<String,String> componentListPackName = new HashMap<String, String>();
    String[] listaStringComponent=null;
    List<String> componentListString=new ArrayList<String>();
    Drawable[] packageIcons=null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiayu_launcher_config_general);

        allow_rotation =(Switch) findViewById(R.id.allow_rotation);
        show_google_bar =(Switch) findViewById(R.id.show_google_bar);
        show_customcontent =(Switch) findViewById(R.id.show_customcontent);
        spinnerApps=(Spinner) findViewById(R.id.spinnerApps);

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
            allow_rotation.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "allow_rotation", false));
            show_google_bar.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "show_google_bar", true));
            show_customcontent.setChecked(Utils.getSharedPreferencesBoolean(getApplicationContext(), "show_customcontent", false));

            getInstalledComponentList();
            listaStringComponent=new String[componentListString.size()];
            for(int x=0;x<componentListString.size();x++){
                listaStringComponent[x]=componentListString.get(x);
            }
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, componentListString);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerApps.setAdapter(new MyAdapter(this, R.layout.spinnerrow, listaStringComponent));
            //spinnerApps.setAdapter(dataAdapter3);
            spinnerApps.setEnabled(show_customcontent.isChecked());
            spinnerApps.setVisibility(View.VISIBLE);
            spinnerApps.setSelection(getSelected(Utils.getSharedPreferences(getApplicationContext(), "app_custom_contentName","Google")));
            if(Utils.getSharedPreferencesBoolean(getApplicationContext(), "show_customcontent", false)){
                spinnerApps.setEnabled(true);
                spinnerApps.setVisibility(View.VISIBLE);
            }else{
                spinnerApps.setEnabled(false);
                spinnerApps.setVisibility(View.INVISIBLE);
            }

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
        packageIcons=new Drawable[componentListString.size()];
        int x=0;
        for (ResolveInfo ri : ril) {
            if (ri.activityInfo != null) {
                packageIcons[x]=ri.activityInfo.loadIcon(getPackageManager());
            }
            x++;
        }
        //componentListString=burbujaOrdenar(componentListString,componentListPack,componentListPackName);
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
                spinnerApps.setVisibility(View.VISIBLE);
            }else{
                show_customcontent.setChecked(false);
                Utils.setSharedPreferencesBoolean(getApplicationContext(), "show_customcontent", false);
                resetLauncher();
                spinnerApps.setEnabled(false);
                spinnerApps.setVisibility(View.INVISIBLE);
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        try {
            Utils.setSharedPreferences(getApplicationContext(), "app_custom_contentPackage",getPackageName(componentListString.get(position)));
            Utils.setSharedPreferences(getApplicationContext(), "app_custom_contentName",getName(getPackageName(componentListString.get(position))));
            resetLauncher();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View view) {

    }

    public class MyAdapter extends ArrayAdapter<String>
    {

        public MyAdapter(Context context, int textViewResourceId, String[] objects)
        {
            super(context, textViewResourceId, objects);
        }


        @Override
        public View getDropDownView(int position, View convertView,ViewGroup parent)
        {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent)
        {

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.spinnerrow, parent, false);
            TextView label=(TextView)row.findViewById(R.id.textView1);
            label.setText(listaStringComponent[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.imageView1);
            icon.setImageDrawable(packageIcons[position]);

            return row;
        }

    }
}