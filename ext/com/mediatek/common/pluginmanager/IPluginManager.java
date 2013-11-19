package com.mediatek.common.pluginmanager;

public abstract interface IPluginManager
{
  public static final String CLASS = "class";
  public static final String CREATE = "create";
  public static final String CREATE_PLUGIN_OBJECT = "createPluginObject";

  public abstract IPlugin getPlugin(int paramInt);

  public abstract int getPluginCount();

  public abstract int refreshPlugin();
}

/* Location:           H:\JIAYU\traduccion\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.mediatek.common.pluginmanager.IPluginManager
 * JD-Core Version:    0.6.0
 */