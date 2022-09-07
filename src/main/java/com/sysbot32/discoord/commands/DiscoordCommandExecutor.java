package com.sysbot32.discoord.commands;

import com.sysbot32.discoord.discord.DiscordWebhook;
import com.sysbot32.discoord.discord.DiscordWebhookRequest;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class DiscoordCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(@Nonnull final CommandSender sender, @Nonnull final Command command, @Nonnull final String label, @Nonnull final String[] args) {
        if (args.length < 2) {
            return false;
        }

        if ("add".equalsIgnoreCase(args[0])) {
            return this.add(sender, command, label, args);
        }
        return false;
    }

    private boolean add(@Nonnull final CommandSender sender, @Nonnull final Command command, @Nonnull final String label, @Nonnull final String[] args) {
        if (sender instanceof final Player player) {
            final Location location = player.getLocation();
            final String message = args[1] + ": " + location.getX() + " / " + location.getY() + " / " + location.getZ();
            sender.sendMessage(message);
            new DiscordWebhook().execute(DiscordWebhookRequest.builder()
                    .content(message)
                    .username(player.getName())
                    .build());
            return true;
        }
        return false;
    }
}
