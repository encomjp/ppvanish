package com.pepe.ppvanish.commands;

import com.pepe.ppvanish.PpVanish;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class cmdVanish implements CommandExecutor {
    private List<Player> vanished = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(sender.hasPermission("ppvanish.vanish")){
            Player player = (Player) sender;
            if(vanished.contains(player)){
                player.sendMessage(ChatColor.AQUA + "Invisibility Disabled");
                vanished.remove(player);
                ((Player) sender).setInvisible(false);
            }else{
                for(Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.hidePlayer(PpVanish.plugin,((Player) player).getPlayer());
                    vanished.add(player);
                }
                sender.sendMessage(ChatColor.AQUA + "Invisibility Enabled");
                ((Player) sender).setInvisible(true);
            }
        }else{
            sender.sendMessage(ChatColor.DARK_RED + "Only players with permission can Vanish");
        }
        }
        return false;
    }
}
