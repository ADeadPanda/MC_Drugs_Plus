package dead.panda;

import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.ArrayList;
import java.util.List;

public class NPCWorldChangeCommand implements CommandExecutor, Listener {
    private static final List<EntityPlayer> NPC = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("npcreload")) {
            if (!(sender instanceof Player)) {
                return true;
            }

            Player player = (Player) sender;
            NpcCreator.addJoinPacket(player.getPlayer());
            PacketReader reader = new PacketReader();
            reader.inject(player.getPlayer());


        }

        return false;
    }
    @EventHandler
    public static void onPlayerTeleport(PlayerChangedWorldEvent event){
        Player player = (Player) event.getPlayer();
        NpcCreator.addJoinPacket(player.getPlayer());
        PacketReader reader = new PacketReader();
        reader.inject(player.getPlayer());
    }
}
