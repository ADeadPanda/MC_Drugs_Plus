package dead.panda.events;

import dead.panda.Drugs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static dead.panda.ItemManager.*;

public class ClickNPC implements Listener {

    private final Drugs plugin;

    public ClickNPC(Drugs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClickNPC(RightClickNPC event) {
        ArrayList<ItemStack> drug = new ArrayList<>();
        drug.add(weed);
        drug.add(heroin);
        drug.add(mushroom);
        drug.add(meth);
        drug.add(acid);
        drug.add(cocaine);
        Player player = event.getPlayer();
        int amountofweedFound = 0;
        int amountofacidFound = 0;
        int amountofheroinFound = 0;
        int amountofmushroomFound = 0;
        int amountofmethFound = 0;
        int amountofcocaineFound = 0;


        for (ItemStack drugs : drug) {
            for (ItemStack item : player.getInventory().getContents()) {
                if (item != null && item.getType() == drugs.getType() && weed.getType() == item.getType()) {
                    amountofweedFound += item.getAmount();
                    drugs.setAmount(amountofweedFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                }
                if (item != null && item.getType() == drugs.getType() && acid.getType() == item.getType()) {
                    amountofacidFound += item.getAmount();
                    drugs.setAmount(amountofacidFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                }
                if (item != null && item.getType() == drugs.getType() && heroin.getType() == item.getType()) {
                    amountofheroinFound += item.getAmount();
                    drugs.setAmount(amountofheroinFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                }
                if (item != null && item.getType() == drugs.getType() && mushroom.getType() == item.getType()) {
                    amountofmushroomFound += item.getAmount();
                    drugs.setAmount(amountofmushroomFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                }
                if (item != null && item.getType() == drugs.getType() && meth.getType() == item.getType()) {
                    amountofmethFound += item.getAmount();
                    drugs.setAmount(amountofmethFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                }
                if (item != null && item.getType() == drugs.getType() && cocaine.getType() == item.getType()) {
                    amountofcocaineFound += item.getAmount();
                    drugs.setAmount(amountofcocaineFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                }
            }
        }
        player.sendMessage(Util.chat("&8&l--------- &a&lDrugs Sold &8&l---------"));
        player.sendMessage(Util.chat("&7Sold &a&l" + amountofweedFound + " &7Weed"));
        plugin.econ.depositPlayer(player, amountofweedFound * 2);
        player.sendMessage(Util.chat("&7Sold &a&l" + amountofacidFound + " &7Acid"));
        plugin.econ.depositPlayer(player, amountofacidFound * 4);
        player.sendMessage(Util.chat("&7Sold &a&l" + amountofmethFound + " &7Meth"));
        plugin.econ.depositPlayer(player, amountofmethFound * 8);
        player.sendMessage(Util.chat("&7Sold &a&l" + amountofcocaineFound + " &7Cocaine"));
        plugin.econ.depositPlayer(player, amountofcocaineFound * 10);
        player.sendMessage(Util.chat("&7Sold &a&l" + amountofmushroomFound + " &7Shrooms"));
        plugin.econ.depositPlayer(player, amountofmushroomFound * 15);
        player.sendMessage(Util.chat("&7Sold &a&l" + amountofheroinFound + " &7Heroin"));
        plugin.econ.depositPlayer(player, amountofheroinFound * 8);
        int total = amountofacidFound * 4 + amountofcocaineFound * 10 + amountofheroinFound * 8 + amountofmushroomFound * 15 + amountofweedFound * 2 + amountofmethFound * 8;
        player.sendMessage(Util.chat(""));
        player.sendMessage(Util.chat("&7&lTotal Profit: &6&l$" + total ));
        player.sendMessage(Util.chat("&8&l-----------------------------"));
    }
}







