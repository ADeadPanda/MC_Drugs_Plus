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
            for (ItemStack item : player.getInventory()) {
                drugs.setAmount(1);
                if (item != null && item.isSimilar(weed)) {
                    amountofweedFound += item.getAmount();
                    drugs.setAmount(amountofweedFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                    if (drug.get(0).getAmount() >= 1) {
                        drug.get(0).setAmount(1);
                    }
                }
            }
        }
        for (ItemStack drugs : drug) {
            for (ItemStack item : player.getInventory()) {
                if (item != null && item.isSimilar(acid)) {
                    amountofacidFound += item.getAmount();
                    drugs.setAmount(amountofacidFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                    if (drug.get(4).getAmount() >= 1) {
                        drug.get(4).setAmount(1);
                    }
                }
                if (item != null && item.isSimilar(heroin)) {
                    amountofheroinFound += item.getAmount();
                    drugs.setAmount(amountofheroinFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                    if (drug.get(1).getAmount() >= 1) {
                        drug.get(1).setAmount(1);
                    }
                }
                if (item != null && item.isSimilar(mushroom)) {
                    amountofmushroomFound += item.getAmount();
                    drugs.setAmount(amountofmushroomFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                    if (drug.get(2).getAmount() >= 1) {
                        drug.get(2).setAmount(1);
                    }
                }
                if (item != null && item.isSimilar(meth)) {
                    amountofmethFound += item.getAmount();
                    drugs.setAmount(amountofmethFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                    if (drug.get(3).getAmount() >= 1) {
                        drug.get(3).setAmount(1);
                    }
                }
                if (item != null && item.isSimilar(cocaine)) {
                    amountofcocaineFound += item.getAmount();
                    drugs.setAmount(amountofcocaineFound);
                    event.getPlayer().getInventory().removeItem(drugs).remove(drugs.getAmount());
                    if (drug.get(5).getAmount() >= 1) {
                        drug.get(5).setAmount(1);
                    }
                }
            }
        }
        int total = amountofacidFound * 4 + amountofcocaineFound * 10 + amountofheroinFound * 8 + amountofmushroomFound * 15 + amountofweedFound * 2 + amountofmethFound * 8;

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

        player.sendMessage(Util.chat(""));
        player.sendMessage(Util.chat("&7&lTotal Profit: &6&l$" + total));
        player.sendMessage(Util.chat("&8&l-----------------------------"));
        if (total >= 0) {
            amountofacidFound = 0;
            amountofcocaineFound = 0;
            amountofheroinFound = 0;
            amountofmethFound = 0;
            amountofmushroomFound = 0;
            amountofweedFound = 0;

        }
    }
}

