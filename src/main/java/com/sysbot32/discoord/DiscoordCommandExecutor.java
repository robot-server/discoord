package com.sysbot32.discoord;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscoordCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length < 2) {
            return false;
        }

        if ("add".equalsIgnoreCase(args[0])) {
            if (sender instanceof final Player player) {
                final Location location = player.getLocation();
                final String message = args[1] + ": " + location.getX() + " / " + location.getY() + " / " + location.getZ();
                sender.sendMessage(message);
                new DiscordWebhook().execute(DiscordWebhookRequest.builder()
                        .content(message)
                        .username(player.getName())
                        .build());
            } else {
                return false;
            }
        }
        return true;
    }
}
