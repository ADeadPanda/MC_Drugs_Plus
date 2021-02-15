package dead.panda;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static dead.panda.ItemManager.*;


public class SellEvent implements Listener {
    private Drugs plugin;

    public SellEvent(Drugs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWeedSell(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        int amount = 100;
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getClickedBlock().getState() instanceof Sign) {
            Sign sign = (Sign) event.getClickedBlock().getState();
            if (sign.getLine(0).equals(Util.chat("&a[Weed]"))) {
                if (event.getItem().getItemMeta().equals(weed.getItemMeta())) {
                    event.getPlayer().sendMessage(Util.chat("&cSold &aWeed&c for &6$100"));
                    if (weed.getAmount() >= 1) {
                        event.getPlayer().getInventory().removeItem(weed).remove(-1, weed);
                        plugin.econ.depositPlayer(player, amount);

                    }
                } else {
                    event.getPlayer().sendMessage(Util.chat("&cUse the correct sign!"));
                }
            }
        }
    }

    @EventHandler
    public void onWeedSignChange(SignChangeEvent event) {
        if (event.getLine(0).equalsIgnoreCase("[Weed]")) {
            if (event.getPlayer().hasPermission("Drugs.sell.create")) {
                event.setLine(0, Util.chat("&a[Weed]"));
                event.setLine(1, Util.chat("&cRight click to sell"));
            }
        }

    }

    @EventHandler
    public void onCokeSell(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        int amount = 100;
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getClickedBlock().getState() instanceof Sign) {
            Sign sign = (Sign) event.getClickedBlock().getState();
            if (sign.getLine(0).equals(Util.chat("&a[Cocaine]"))) {
                if (event.getItem().getItemMeta().equals(cocaine.getItemMeta())) {
                    event.getPlayer().sendMessage(Util.chat("&cSold &f&lCocaine &r&cfor &6$100"));
                    if (cocaine.getAmount() >= 1) {
                        event.getPlayer().getInventory().removeItem(cocaine).remove(-1, cocaine);
                        plugin.econ.depositPlayer(player, amount);

                    }
                } else {
                    event.getPlayer().sendMessage(Util.chat("&cUse the correct sign!"));
                }
            }
        }

    }

    @EventHandler
    public void onCokeSignChange(SignChangeEvent event) {
        if (event.getLine(0).equalsIgnoreCase("[Cocaine]")) {
            if (event.getPlayer().hasPermission("Drugs.sell.create")) {
                event.setLine(0, Util.chat("&a[Cocaine]"));
                event.setLine(1, Util.chat("&cRight click to sell"));
            }
        }

    }

    @EventHandler
    public void onMushroomSell(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        int amount = 100;
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getClickedBlock().getState() instanceof Sign) {
            Sign sign = (Sign) event.getClickedBlock().getState();
            if (sign.getLine(0).equals(Util.chat("&a[Shrooms]"))) {
                if (event.getItem().getItemMeta().equals(mushroom.getItemMeta())) {
                    event.getPlayer().sendMessage(Util.chat("&cSold &f&lShrooms &r&cfor &6$100"));
                    if (mushroom.getAmount() >= 1) {
                        event.getPlayer().getInventory().removeItem(mushroom).remove(-1, mushroom);
                        plugin.econ.depositPlayer(player, amount);

                    }
                } else {
                    event.getPlayer().sendMessage(Util.chat("&cUse the correct sign!"));
                }
            }
        }

    }

    @EventHandler
    public void onMushroomSignChange(SignChangeEvent event) {
        if (event.getLine(0).equalsIgnoreCase("[Shrooms]")) {
            if (event.getPlayer().hasPermission("Drugs.sell.create")) {
                event.setLine(0, Util.chat("&a[Shrooms]"));
                event.setLine(1, Util.chat("&cRight click to sell"));
            }
        }

    }

    @EventHandler
    public void onHeroinSell(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        int amount = 100;
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getClickedBlock().getState() instanceof Sign) {
            Sign sign = (Sign) event.getClickedBlock().getState();
            if (sign.getLine(0).equals(Util.chat("&a[Heroin]"))) {
                if (event.getItem().getItemMeta().equals(heroin.getItemMeta())) {
                    event.getPlayer().sendMessage(Util.chat("&cSold &f&lHeroin &r&cfor &6$100"));
                    if (heroin.getAmount() >= 1) {
                        event.getPlayer().getInventory().removeItem(heroin).remove(-1, heroin);
                        plugin.econ.depositPlayer(player, amount);

                    }
                } else {
                    event.getPlayer().sendMessage(Util.chat("&cUse the correct sign!"));
                }
            }
        }

    }

    @EventHandler
    public void onHeroinSignChange(SignChangeEvent event) {
        if (event.getLine(0).equalsIgnoreCase("[Heroin]")) {
            if (event.getPlayer().hasPermission("Drugs.sell.create")) {
                event.setLine(0, Util.chat("&a[Heroin]"));
                event.setLine(1, Util.chat("&cRight click to sell"));
            }
        }

    }

    @EventHandler
    public void onAcidSell(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        int amount = 100;
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getClickedBlock().getState() instanceof Sign) {
            Sign sign = (Sign) event.getClickedBlock().getState();
            if (sign.getLine(0).equals(Util.chat("&a[Acid]"))) {
                if (event.getItem().getItemMeta().equals(acid.getItemMeta())) {
                    event.getPlayer().sendMessage(Util.chat("&cSold &f&lAcid &r&cfor &6$100"));
                    if (acid.getAmount() >= 1) {
                        event.getPlayer().getInventory().removeItem(acid).remove(-1, acid);
                        plugin.econ.depositPlayer(player, amount);

                    }
                } else {
                    event.getPlayer().sendMessage(Util.chat("&cUse the correct sign!"));
                }
            }
        }

    }

    @EventHandler
    public void onAcidSignChange(SignChangeEvent event) {
        if (event.getLine(0).equalsIgnoreCase("[Acid]")) {
            if (event.getPlayer().hasPermission("Drugs.sell.create")) {
                event.setLine(0, Util.chat("&a[Acid]"));
                event.setLine(1, Util.chat("&cRight click to sell"));
            }
        }

    }

    @EventHandler
    public void onMethSell(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        int amount = 100;
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getClickedBlock().getState() instanceof Sign) {
            Sign sign = (Sign) event.getClickedBlock().getState();
            if (sign.getLine(0).equals(Util.chat("&a[Meth]"))) {
                if (event.getItem().getItemMeta().equals(meth.getItemMeta())) {
                    event.getPlayer().sendMessage(Util.chat("&cSold &f&lMeth &r&cfor &6$100"));
                    if (meth.getAmount() >= 1) {
                        event.getPlayer().getInventory().removeItem(meth).remove(-1, meth);
                        plugin.econ.depositPlayer(player, amount);

                    }
                } else {
                    event.getPlayer().sendMessage(Util.chat("&cUse the correct sign!"));
                }
            }
        }

    }

    @EventHandler
    public void onMethSignChange(SignChangeEvent event) {
        if (event.getLine(0).equalsIgnoreCase("[Meth]")) {
            if (event.getPlayer().hasPermission("Drugs.sell.create")) {
                event.setLine(0, Util.chat("&a[Meth]"));
                event.setLine(1, Util.chat("&cRight click to sell"));
            }
        }

    }
}
