package com.pepe.ppvanish;

import com.pepe.ppvanish.commands.cmdVanish;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PpVanish extends JavaPlugin {
    public static Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        System.out.println("[ppVanish] - Has successfully started");
        getCommand("ppvanish").setExecutor(new cmdVanish());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
