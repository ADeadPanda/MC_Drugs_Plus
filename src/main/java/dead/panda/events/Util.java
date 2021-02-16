package dead.panda.events;

import org.bukkit.ChatColor;

public class Util {
    public static String chat(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
