package dev._2lstudios.gameessentials.commands;

import dev._2lstudios.gameessentials.instanceables.ScoreboardPlayer;
import dev._2lstudios.gameessentials.managers.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import dev._2lstudios.gameessentials.managers.EssentialsManager;
import org.bukkit.command.CommandExecutor;

public class ScoreboardCMD implements CommandExecutor {
    private final EssentialsManager essentialsManager;

    public ScoreboardCMD(final EssentialsManager essentialsManager) {
        this.essentialsManager = essentialsManager;
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final PlayerManager playerManager = this.essentialsManager.getPlayerManager();
            final Player player = (Player) sender;
            final ScoreboardPlayer essentialsPlayer = playerManager.getPlayer(player.getUniqueId());
            if (essentialsPlayer.isScoreboardEnabled()) {
                essentialsPlayer.setScoreboardEnabled(false);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cDeshabilitaste el Scoreboard!"));
            } else {
                essentialsPlayer.setScoreboardEnabled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aHabilitaste el Scoreboard!"));
            }
        } else {
            sender.sendMessage(ChatColor.RED + "No puedes ejecutar este comando desde la consola!");
        }
        return true;
    }
}
