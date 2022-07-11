package me.penta.anticheat.flagger;

import me.penta.anticheat.flagger.flags.Flag;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FlagManager {
    public static void flagPlayer(Player player, Flag flag) {
        Bukkit.getLogger().info(String.format("player %s flaged with %s", player.getName(), flag.name));
    }
}
