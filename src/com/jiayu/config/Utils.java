// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst noctor space 

package com.jiayu.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import java.io.*;

public class Utils
{


    public static String convertStreamToString(InputStream inputstream)
        throws Exception
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            String s = bufferedreader.readLine();
            if (s == null)
                return stringbuilder.toString();
            stringbuilder.append(s).append("\n");
        } while (true);
    }

    public static void deleteAllSharedPreferences(Context context)
    {
        PreferenceManager.getDefaultSharedPreferences(context).edit().clear().commit();
    }

    public static void deleteSharedPreferences(Context context, String s)
    {
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove(s).commit();
    }

    public static int dpToPx(Resources resources, int i)
    {
        return (int)TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    public static String getSharedPreferences(Context context, String s, String s1)
    {
        if (s1 == null || s1.equalsIgnoreCase(""))
            s1 = "";
        return PreferenceManager.getDefaultSharedPreferences(context).getString(s, s1);
    }

    public static boolean getSharedPreferencesBoolean(Context context, String s, boolean flag)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(s, flag);
    }

    public static float getSharedPreferencesFloat(Context context, String s, float f)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(s, f);
    }

    public static int getSharedPreferencesInt(Context context, String s, int i)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(s, i);
    }

    public static void setSharedPreferences(Context context, String s, String s1)
    {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(s, s1);
        editor.commit();
    }

    public static void setSharedPreferencesBoolean(Context context, String s, boolean flag)
    {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(s, flag);
        editor.commit();
    }

    public static void setSharedPreferencesFloat(Context context, String s, float f)
    {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putFloat(s, f);
        editor.commit();
    }

    public static void setSharedPreferencesInt(Context context, String s, int i)
    {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(s, i);
        editor.commit();
    }
}
