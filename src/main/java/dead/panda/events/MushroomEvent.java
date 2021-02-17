package dead.panda.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static dead.panda.ItemManager.mushroom;

public class MushroomEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta().equals(mushroom.getItemMeta())) {
                    if (player.isSneaking()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 2));
                        if (mushroom.getAmount() >= 1) {
                            player.getInventory().removeItem(mushroom).remove(-1, mushroom);
                        }
                    }
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        if (e.getBlock().getType() == Material.BROWN_MUSHROOM) {
            e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), mushroom);
            e.setDropItems(false);
        }
        if (e.getBlock().getType() == Material.RED_MUSHROOM) {
            e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), mushroom);
            e.setDropItems(false);
        }
    }

}
