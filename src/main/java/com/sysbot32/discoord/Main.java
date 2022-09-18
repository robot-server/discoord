package com.sysbot32.discoord;

import com.sysbot32.discoord.commands.CoordCommandExecutor;
import com.sysbot32.discoord.commands.DiscoordCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Config.config = getConfig();
        Config.getConfig().options().copyDefaults(true);
        saveConfig();

        getCommand("coord").setExecutor(new CoordCommandExecutor());
        getCommand("discoord").setExecutor(new DiscoordCommandExecutor());
    }
}
