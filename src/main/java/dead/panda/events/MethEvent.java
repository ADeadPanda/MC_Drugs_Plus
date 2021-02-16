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

import static dead.panda.ItemManager.meth;

public class MethEvent implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta().equals(meth.getItemMeta())) {
                    if (player.isSneaking()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 120, 3));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 120, 2));
                        player.damage(15);
                        if (meth.getAmount() >= 1) {
                            player.getInventory().removeItem(meth).remove(-1, meth);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.BLUE_ICE) {
            e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), meth);
            e.setDropItems(false);
        }
    }
}

