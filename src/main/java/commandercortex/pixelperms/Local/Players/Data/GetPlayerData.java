package commandercortex.pixelperms.Local.Players.Data;

import org.bukkit.entity.Player;

public class GetPlayerData {
    public static String getPlayer(Player player){
        return "plugins/PixelPerms/players/" + player.getUniqueId() + ".yml";
    }
}
