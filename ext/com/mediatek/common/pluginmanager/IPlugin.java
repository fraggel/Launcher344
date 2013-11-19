package com.mediatek.common.pluginmanager;

import android.content.Context;
import android.content.res.Resources;

public abstract interface IPlugin
{
  public abstract Object createObject()
    throws Exception;

  public abstract Object createObject(String paramString)
    throws Exception;

  public abstract Context getContext();

  public abstract int getMetaDataResourceID(String paramString);

  public abstract boolean getMetaDataValueBoolean(String paramString);

  public abstract int getMetaDataValueColor(String paramString);

  public abstract float getMetaDataValueFloat(String paramString);

  public abstract int getMetaDataValueInt(String paramString);

  public abstract String getMetaDataValueString(String paramString);

  public abstract CharSequence getName();

  public abstract Resources getResources();
}

/* Location:           H:\JIAYU\traduccion\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.mediatek.common.pluginmanager.IPlugin
 * JD-Core Version:    0.6.0
 */