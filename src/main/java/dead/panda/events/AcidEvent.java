package dead.panda.events;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static dead.panda.ItemManager.acid;

public class AcidEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta().equals(acid.getItemMeta())) {
                    if (player.isSneaking()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 10, 1));
                        player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 10, 10);
                        player.playSound(player.getLocation(), Sound.ENTITY_GHAST_DEATH, 100, 0);
                        player.playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 100);
                        if (acid.getAmount() >= 1) {
                            player.getInventory().removeItem(acid).remove(-1, acid);
                        }
                    }
                }
            }
        }
    }
}

