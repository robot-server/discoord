package com.sysbot32.discoord;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    static FileConfiguration config;

    public static FileConfiguration getConfig() {
        return config;
    }

    public static String getWebhookUrl() {
        return config.getString("webhookUrl");
    }
}
