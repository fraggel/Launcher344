package com.mediatek.pluginmanager;

import android.content.Context;
import android.content.res.Resources;

import com.mediatek.common.pluginmanager.IPlugin;

public final class Plugin<T>
  implements IPlugin
{

    @Override
    public Object createObject() throws Exception {
        return null;
    }

    @Override
    public Object createObject(String paramString){
        return null;
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public int getMetaDataResourceID(String paramString) {
        return 0;
    }

    @Override
    public boolean getMetaDataValueBoolean(String paramString) {
        return false;
    }

    @Override
    public int getMetaDataValueColor(String paramString) {
        return 0;
    }

    @Override
    public float getMetaDataValueFloat(String paramString) {
        return 0;
    }

    @Override
    public int getMetaDataValueInt(String paramString) {
        return 0;
    }

    @Override
    public String getMetaDataValueString(String paramString) {
        return null;
    }

    @Override
    public CharSequence getName() {
        return null;
    }

    @Override
    public Resources getResources() {
        return null;
    }

    public static class ObjectCreationException extends Throwable{
        public ObjectCreationException(String a)
        {}
    }
}

/* Location:           H:\JIAYU\traduccion\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.mediatek.pluginmanager.Plugin
 * JD-Core Version:    0.6.0
 */