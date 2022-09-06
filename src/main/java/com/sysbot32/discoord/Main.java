package com.sysbot32.discoord;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("discoord").setExecutor(new DiscoordCommandExecutor());
    }
}
