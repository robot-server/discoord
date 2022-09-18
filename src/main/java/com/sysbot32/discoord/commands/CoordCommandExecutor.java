package com.sysbot32.discoord.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class CoordCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(@Nonnull final CommandSender sender, @Nonnull final Command command, @Nonnull final String label, @Nonnull final String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /coord <name>");
            return false;
        }

        if (sender instanceof final Player player) {
            final Location location = player.getLocation();
            final String message = args[0] + ": " + location.getX() + " / " + location.getY() + " / " + location.getZ();
            player.chat(message);
            return true;
        }
        return false;
    }
}
