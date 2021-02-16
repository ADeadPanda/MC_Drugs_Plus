package dead.panda.events;

import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static dead.panda.ItemManager.weed;
import static dead.panda.ItemManager.weedseed;

public class WeedEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta().equals(weed.getItemMeta())) {
                    if (player.isSneaking()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 300, 1));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 150, 1));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20 * 3, 1));
                        if (weed.getAmount() >= 1) {
                            player.getInventory().removeItem(weed).remove(-1, weed);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        BlockData bdata = e.getBlock().getBlockData();
        if (bdata instanceof Ageable) {
            Ageable age = (Ageable) bdata;
            if (age.getAge() == age.getMaximumAge()) {
                if (e.getBlock().getType() == Material.WHEAT) {
                    e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), weed);
                    e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), weedseed);
                    e.setDropItems(false);
                }
            }

        }
    }

}
