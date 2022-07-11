package me.penta.anticheat.event.block;

import me.penta.anticheat.flagger.FlagManager;
import me.penta.anticheat.flagger.FlagTypes;
import me.penta.anticheat.flagger.flags.ReachFlag;
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

        double reach = Utils3d.getDistance(event.getBlock().getLocation(), event.getBlock().getLocation());

        if (Utils3d.getDistance(event.getBlock().getLocation(), event.getBlock().getLocation()) > 5.6){
            event.setCancelled(true);
            FlagManager.flagPlayer(event.getPlayer(), new ReachFlag(reach, FlagTypes.ReachType.BLOCK_INTERACTION));
        }
    }
}
