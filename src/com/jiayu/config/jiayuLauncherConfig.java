package com.jiayu.config;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fraggel.launcher.R;

/**
 * Created by Fraggel on 16/11/13.
 */
public class jiayuLauncherConfig extends Activity implements View.OnClickListener{

    Button general=null;
    Button escritorio=null;
    Button cajon=null;
    Button inferior=null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiayu_launcher_config_main);
        general=(Button)findViewById(R.id.btnGenerales);
        escritorio=(Button)findViewById(R.id.btnEscritorio);
        cajon=(Button)findViewById(R.id.btnCajon);
        inferior=(Button)findViewById(R.id.btnInferiores);
        general.setOnClickListener(this);
        escritorio.setOnClickListener(this);
        cajon.setOnClickListener(this);
        inferior.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent it=null;
        if(view.getId()==R.id.btnGenerales){
            it=new Intent(getApplicationContext(),jiayuLauncherConfigGeneral.class);
        }else if(view.getId()==R.id.btnEscritorio){
            it=new Intent(getApplicationContext(),jiayuLauncherConfigEscritorio.class);
        }else if(view.getId()==R.id.btnCajon){
            it=new Intent(getApplicationContext(),jiayuLauncherConfigCajon.class);
        }else if(view.getId()==R.id.btnInferiores){
            it=new Intent(getApplicationContext(),jiayuLauncherConfigInferior.class);
        }
        if(it!=null){
            startActivity(it);
        }
    }
}