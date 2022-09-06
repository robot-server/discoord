package com.sysbot32.discoord;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Builder
@Getter
public class DiscordWebhookRequest {
    @Nonnull
    private final String content;
    @Nullable
    private final String username;

    @Override
    public String toString() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content", this.content);
        jsonObject.addProperty("username", this.username);
        return jsonObject.toString();
    }
}
