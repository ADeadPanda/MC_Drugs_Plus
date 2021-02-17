package dead.panda;

import dead.panda.events.Util;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {

    public static ItemStack weed;
    public static ItemStack weed_seed;
    public static ItemStack cocaine;
    public static ItemStack mushroom;
    public static ItemStack heroin;
    public static ItemStack acid;
    public static ItemStack meth;

    public static void init() {
        createWeed();
        createCocaine();
        createWeedseed();
        createMushroom();
        createHeroin();
        createAcid();
        createMeth();

    }

    private static void createWeed() {
        ItemStack item = new ItemStack(Material.GREEN_DYE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Util.chat("&a&lWeed"));
        item.setItemMeta(meta);
        weed = item;
    }

    private static void createWeedseed() {
        ItemStack item = new ItemStack(Material.WHEAT_SEEDS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Util.chat("&a&lWeed Seed"));
        item.setItemMeta(meta);
        weed_seed = item;
    }

    private static void createCocaine() {
        ItemStack item = new ItemStack(Material.SUGAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Util.chat("&f&lCocaine"));
        item.setItemMeta(meta);
        cocaine = item;
    }

    private static void createMushroom() {
        ItemStack item = new ItemStack(Material.WARPED_FUNGUS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Util.chat("&f&lShrooms"));
        item.setItemMeta(meta);
        mushroom = item;
    }

    private static void createHeroin() {
        ItemStack item = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Util.chat("&f&lHeroin"));
        item.setItemMeta(meta);
        heroin = item;
    }

    private static void createAcid() {
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Util.chat("&f&lACID"));
        item.setItemMeta(meta);
        acid = item;
    }

    private static void createMeth() {
        ItemStack item = new ItemStack(Material.QUARTZ, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Util.chat("&f&lMeth"));
        item.setItemMeta(meta);
        meth = item;
    }
}
