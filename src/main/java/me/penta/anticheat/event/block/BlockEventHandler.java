package me.penta.anticheat.event.block;

import me.penta.anticheat.utils.utils3d.Utils3d;
import me.penta.anticheat.utils.utils3d.Vector3;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockEventHandler implements Listener {

    public BlockEventHandler() {

    }

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {
        if (Utils3d.getDistance(event.getBlock().getLocation(), event.getBlock().getLocation()) > 5.6){
            event.setCancelled(true);
        }
    }
}
