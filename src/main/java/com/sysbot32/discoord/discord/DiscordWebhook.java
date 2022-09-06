package com.sysbot32.discoord.discord;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DiscordWebhook {
    final private String webhookUrl = "https://discord.com/api/webhooks/{webhook.id}/{webhook.token}";

    public void execute(final DiscordWebhookRequest request) {
        try {
            HttpsURLConnection conn = (HttpsURLConnection) new URL(webhookUrl).openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setDoOutput(true);
            conn.getOutputStream().write(request.toString().getBytes(StandardCharsets.UTF_8));

            try {
                conn.getInputStream();
            } catch (IOException e) {
                System.err.println(new BufferedReader(new InputStreamReader(conn.getErrorStream())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
