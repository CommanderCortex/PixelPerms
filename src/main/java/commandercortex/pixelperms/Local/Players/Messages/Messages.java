package commandercortex.pixelperms.Local.Players.Messages;

import commandercortex.pixelperms.Global.Color;
import org.bukkit.entity.Player;

public class Messages extends Color {
    public static int Message(Player player, String Message){
        player.sendMessage(C(prefix+Message));
        return 0;
    }
}
