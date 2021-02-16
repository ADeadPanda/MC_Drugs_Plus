package dead.panda.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static dead.panda.ItemManager.cocaine;

public class CocaineEvent implements Listener {


    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta().equals(cocaine.getItemMeta())) {
                    if (player.isSneaking()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 30, 5));
                        player.damage(15);
                        player.setNoDamageTicks(20 * 5);
                        if (cocaine.getAmount() >= 1) {
                            player.getInventory().removeItem(cocaine).remove(-1, cocaine);
                        }
                    }
                }
            }
        }
    }
}

