package me.penta.anticheat;

import me.penta.anticheat.event.pvp.PvpEventHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiCheat extends JavaPlugin {
    public static final double playerSizeX = .6;
    public static final double playerSizeY = 1.8;
    public static final double playerSizeZ = .6;
    public static final double playerEyeHeight = 1.6;
    public static final double maxPlayerReach = 4.5;
    public static final double maxHitError = .7;

    @Override
    public void onEnable() {
        PluginManager manager = Bukkit.getServer().getPluginManager();
        manager.registerEvents(new PvpEventHandler(), this);
        Bukkit.getLogger().info("AntiCheat started");
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
