package dead.panda;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import dead.panda.events.*;
import net.milkbowl.vault.economy.Economy;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.UUID;

import static dead.panda.ItemManager.acid;
import static dead.panda.ItemManager.cocaine;

public final class Drugs extends JavaPlugin {
    public Economy econ;

    public static DataManager data;

    @Override
    public void onEnable() {
        data = new DataManager(this);
        if (data.getConfig().contains("data")) {
            loadNPC();
        }
        if (!Bukkit.getOnlinePlayers().isEmpty())
            for (Player player : Bukkit.getOnlinePlayers()) {
                PacketReader reader = new PacketReader();
                reader.inject(player);
            }
        if (!setupEconomy()) {
            System.out.println(Util.chat("&cYou must have Vault and an Economy plugin installed!"));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        ItemManager.init();
        this.getServer().getPluginManager().registerEvents(new ClickNPC(this), this);
        this.getServer().getPluginManager().registerEvents(new WeedEvent(), this);
        this.getServer().getPluginManager().registerEvents(new NpcCommand(), this);
        this.getServer().getPluginManager().registerEvents(new CocaineEvent(), this);
        this.getServer().getPluginManager().registerEvents(new MushroomEvent(), this);
        this.getServer().getPluginManager().registerEvents(new HeroinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new AcidEvent(), this);
        this.getServer().getPluginManager().registerEvents(new MethEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SellEvent(this), this);
        this.getCommand("npccreate").setExecutor(new NpcCommand());
        cocaineRecipe();
        acidRecipe();


    }

    public void loadNPC() {
        FileConfiguration file = data.getConfig();
        file.getConfigurationSection("data").getKeys(false).forEach(npc -> {
            Location location = new Location(Bukkit.getWorld(Objects.requireNonNull(file.getString("data." + npc + ".world"))), file.getInt("data." + npc + ".x"), file.getInt("data." + npc + ".y"), file.getInt("data." + npc + ".z"));
            location.setPitch((float) file.getDouble("data." + npc + ".pitch"));
            location.setYaw((float) file.getDouble("data." + npc + ".yaw"));

            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), Util.chat("&a&lDrug Dealer"));
            gameProfile.getProperties().put("textures", new Property("textures", file.getString("data." + npc + ".text"), file.getString("data." + npc + ".signature")));

            NpcCreator.loadNPC(location, gameProfile);
        });
    }

    @Override
    public void onDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PacketReader reader = new PacketReader();
            reader.uninject(player);
            for (EntityPlayer npc : NpcCreator.getNPCs()) {
                NpcCreator.removeNPC(player, npc);
            }

        }
    }

    public static FileConfiguration getData() {
        return data.getConfig();
    }

    public static void saveData() {
        data.saveConfig();
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
