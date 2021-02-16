package dead.panda.events;

import dead.panda.Drugs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static dead.panda.ItemManager.*;

public class ClickNPC implements Listener {

    private Drugs plugin;

    public ClickNPC(Drugs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWeedNpc(RightClickNPC event) {
        Player player = event.getPlayer();
        int amount = 100;
        if (player.getInventory().getItemInMainHand() == null) return;
        if (player.getInventory().getItemInMainHand().getItemMeta().equals(weed.getItemMeta())) {
            if (weed.getAmount() >= 1) {
                event.getPlayer().getInventory().removeItem(weed).remove(-1, weed);
                player.sendMessage(Util.chat("&cSold 1 &aWeed &cfor &6 $100"));
                plugin.econ.depositPlayer(player, amount);
            }
        } else if (player.getInventory().getItemInMainHand().getItemMeta().equals(acid.getItemMeta())){
            if (acid.getAmount() >= 1) {
                event.getPlayer().getInventory().removeItem(acid).remove(-1, acid);
                player.sendMessage(Util.chat("&cSold 1 &fAcid &cfor &6 $100"));
                plugin.econ.depositPlayer(player, amount);
            }
        } else if (player.getInventory().getItemInMainHand().getItemMeta().equals(cocaine.getItemMeta())){
            if (cocaine.getAmount() >= 1) {
                event.getPlayer().getInventory().removeItem(cocaine).remove(-1, cocaine);
                player.sendMessage(Util.chat("&cSold 1 &fCocaine &cfor &6 $100"));
                plugin.econ.depositPlayer(player, amount);
            }
        } else if (player.getInventory().getItemInMainHand().getItemMeta().equals(mushroom.getItemMeta())){
            if (mushroom.getAmount() >= 1) {
                event.getPlayer().getInventory().removeItem(mushroom).remove(-1, mushroom);
                player.sendMessage(Util.chat("&cSold 1 &fShrooms &cfor &6 $100"));
                plugin.econ.depositPlayer(player, amount);
            }
        } else if (player.getInventory().getItemInMainHand().getItemMeta().equals(heroin.getItemMeta())){
            if (heroin.getAmount() >= 1) {
                event.getPlayer().getInventory().removeItem(heroin).remove(-1, heroin);
                player.sendMessage(Util.chat("&cSold 1 &fHeroin &cfor &6 $100"));
                plugin.econ.depositPlayer(player, amount);
            }
        } else if (player.getInventory().getItemInMainHand().getItemMeta().equals(meth.getItemMeta())){
            if (meth.getAmount() >= 1) {
                event.getPlayer().getInventory().removeItem(meth).remove(-1, meth);
                player.sendMessage(Util.chat("&cSold 1 &fMeth &cfor &6 $100"));
                plugin.econ.depositPlayer(player, amount);
            }
        }
    }
}
