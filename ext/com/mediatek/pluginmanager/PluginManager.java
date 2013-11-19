package com.mediatek.pluginmanager;


import android.content.Context;

import com.android.launcher2.ext.IAllAppsListExt;
import com.mediatek.common.pluginmanager.IPlugin;
import com.mediatek.common.pluginmanager.IPluginManager;

public final class PluginManager<T>
  implements IPluginManager
{

    @Override
    public IPlugin getPlugin(int paramInt) {
        return null;
    }

    @Override
    public int getPluginCount() {
        return 0;
    }

    @Override
    public int refreshPlugin() {
        return 0;
    }

    public static IAllAppsListExt createPluginObject(Context context, String name) throws Plugin.ObjectCreationException{
        return null;
    }
}

/* Location:           H:\JIAYU\traduccion\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.mediatek.pluginmanager.PluginManager
 * JD-Core Version:    0.6.0
 */