package com.fraggel.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.ViewGroup;

/**
 * Created by U028952 on 26/11/13.
 */
public class CustomView extends ViewGroup implements Launcher.CustomContentCallbacks {
    public CustomView(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public void onShow() {
/*
        PackageManager pm = getContext().getPackageManager();
        Intent i = new Intent();
        String pack=Utils.getSharedPreferences(getContext(),"app_custom_contentPackage","com.google.android.googlequicksearchbox");
        i = pm.getLaunchIntentForPackage(pack);
        getContext().startActivity(i);
*/
        String pack=Utils.getSharedPreferences(getContext(),"app_custom_contentPackage",null);
        if(pack!=null){
            String pck=pack.split("/")[0];
            String name=pack.split("/")[1];
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(pck, name));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(intent);
        }
        System.exit(0);

    }
    @Override
    public void onHide() {
    }

    @Override
    public void onScrollProgressChanged(float progress) {

    }
}
