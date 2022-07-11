package me.penta.anticheat.event.pvp;

import me.penta.anticheat.AntiCheat;
import me.penta.anticheat.flagger.FlagManager;
import me.penta.anticheat.flagger.flags.KillAuraFlag;
import me.penta.anticheat.flagger.flags.ReachFlag;
import me.penta.anticheat.utils.utils3d.Box;
import me.penta.anticheat.utils.utils3d.Utils3d;
import me.penta.anticheat.utils.utils3d.Vector3;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvpEventHandler implements Listener {

    public PvpEventHandler() {
    }

    @EventHandler
    public void onHitExchange(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Entity sender = event.getDamager();
        Entity receiver = event.getEntity();

        didHitPlayer((Player) sender, receiver, event);
    }

    public void didHitPlayer(Player attacker, Entity attacked, EntityDamageByEntityEvent event) {
        double maxError = AntiCheat.maxHitError;

        Vector3 playerLoc = new Vector3(attacked.getLocation());
        playerLoc.y += AntiCheat.playerSizeY / 2;
        Box player = new Box(playerLoc, AntiCheat.playerSizeX, AntiCheat.playerSizeY, AntiCheat.playerSizeZ);

        Vector3 pos = new Vector3(attacker.getLocation());
        pos.y += AntiCheat.playerEyeHeight;


        double distance = Utils3d.getDistance(attacked.getLocation(), attacker.getLocation()) + 2;
        double distanceCovered = 0;
        double minDistance = Double.MAX_VALUE;

        Vector3 point = player.pos;
        Bukkit.getLogger().info("" + player.getDistanceToBox(new Vector3(attacker.getEyeLocation())));

        if (player.getDistanceToBox(new Vector3(attacker.getEyeLocation())) > 3.3){
            FlagManager.flagPlayer(attacker, new ReachFlag());
            event.setCancelled(true);
        }

        while (distanceCovered < distance) {
            double disToBox = player.getDistanceToBox(point);
            if (disToBox < minDistance) {
                minDistance = disToBox;
            }

            point.x += distanceCovered * Math.sin(attacker.getLocation().getYaw()) * Math.cos(attacker.getLocation().getPitch());
            point.y += distanceCovered * Math.sin(attacker.getLocation().getPitch());
            point.z += distanceCovered * Math.sin(attacker.getLocation().getYaw()) * Math.cos(attacker.getLocation().getPitch());

            distanceCovered += .3;

        }

        if (minDistance > maxError) {
            FlagManager.flagPlayer(attacker, new KillAuraFlag());
        }
    }
}
