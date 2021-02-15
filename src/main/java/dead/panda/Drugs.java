package dead.panda;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import static dead.panda.ItemManager.acid;
import static dead.panda.ItemManager.cocaine;

public final class Drugs extends JavaPlugin {
    public Economy econ;

    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            System.out.println(Util.chat("&cYou must have Vault and an Economy plugin installed!"));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        ItemManager.init();
        this.getServer().getPluginManager().registerEvents(new WeedEvent(), this);
        this.getServer().getPluginManager().registerEvents(new CocaineEvent(), this);
        this.getServer().getPluginManager().registerEvents(new MushroomEvent(), this);
        this.getServer().getPluginManager().registerEvents(new HeroinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new AcidEvent(), this);
        this.getServer().getPluginManager().registerEvents(new MethEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SellEvent(this), this);
        cocaineRecipe();
        acidRecipe();
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economy != null) {
            econ = economy.getProvider();
        }
        return (econ != null);
    }

    public void cocaineRecipe() {
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(new NamespacedKey(this, "cocaine"), new ItemStack(cocaine)).
                addIngredient(Material.COCOA_BEANS);
        (this).getServer().addRecipe(shapelessRecipe);
    }

    public void acidRecipe() {
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(new NamespacedKey(this, "acid"), new ItemStack(acid)).
                addIngredient(Material.SUGAR_CANE);
        (this).getServer().addRecipe(shapelessRecipe);
    }
}
