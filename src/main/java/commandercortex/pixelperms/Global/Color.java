package commandercortex.pixelperms.Global;

import org.bukkit.ChatColor;

public class Color {
    public static String C(String Message){
        return ChatColor.translateAlternateColorCodes('&', Message);
    }

    public static String prefix = "&7[&b&lPixelPerms&r&7] &r-> &r";
}
