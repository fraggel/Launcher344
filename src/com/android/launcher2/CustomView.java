package com.android.launcher2;

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

        PackageManager pm = getContext().getPackageManager();
        Intent i = new Intent();
        String pack=Utils.getSharedPreferences(getContext(),"app_custom_content","com.google.android.googlequicksearchbox");
        i = pm.getLaunchIntentForPackage(pack);
        getContext().startActivity(i);
        System.exit(0);

    }
    @Override
    public void onHide() {
    }

    @Override
    public void onScrollProgressChanged(float progress) {

    }
}
