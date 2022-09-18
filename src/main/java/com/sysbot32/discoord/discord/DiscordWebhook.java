package com.sysbot32.discoord.discord;

import com.sysbot32.discoord.Config;
import org.bukkit.Bukkit;

import javax.annotation.Nonnull;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DiscordWebhook {
    private final String webhookUrl = Config.getWebhookUrl();

    public void execute(@Nonnull final DiscordWebhookRequest request) {
        try {
            HttpsURLConnection conn = (HttpsURLConnection) new URL(webhookUrl).openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setDoOutput(true);
            conn.getOutputStream().write(request.toString().getBytes(StandardCharsets.UTF_8));

            try {
                conn.getInputStream();
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(new BufferedReader(new InputStreamReader(conn.getErrorStream())).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
