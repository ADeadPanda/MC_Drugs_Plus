package dead.panda;

import dead.panda.events.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class NpcCommand implements Listener, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("npccreate")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            Player player = (Player) sender;
            if (player.hasPermission("Drugs.npc.create")) {
                if (args.length == 0) {
                    NpcCreator.createNPC(player, player.getName());
                    NpcCreator.createNPC(player, player.getName());
                    player.sendMessage(Util.chat("&bNPC Created"));
                }
                NpcCreator.createNPC(player, args[0]);
                player.sendMessage(Util.chat("&bNPC Created"));
            }
        }
        return false;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (NpcCreator.getNPCs() == null)
            return;
        if (NpcCreator.getNPCs().isEmpty())
            return;
        NpcCreator.addJoinPacket(event.getPlayer());

        PacketReader reader = new PacketReader();
        reader.inject(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        PacketReader reader = new PacketReader();
        reader.uninject(event.getPlayer());
    }

}
