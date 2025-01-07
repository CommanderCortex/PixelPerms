package commandercortex.pixelperms.Global.Chat;

import commandercortex.pixelperms.Global.Color;
import commandercortex.pixelperms.Local.Permissions.GroupManager;
import commandercortex.pixelperms.Local.Players.Messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnChatEvent implements Listener {
    GroupManager groupManager = new GroupManager();
    @EventHandler
    public void Chat(AsyncPlayerChatEvent chatEvent){
        chatEvent.setCancelled(true);
        Player player = chatEvent.getPlayer();
        String Message = chatEvent.getMessage();
        String DisplayName = player.getDisplayName();
        String GroupPrefix = groupManager.GroupPrefix(groupManager.getGroup(player));

        String FormattedMessage = GroupPrefix + "&7[&r" + DisplayName + "&7]&r" + " &a>> &r"+ Message;
        
        Bukkit.broadcastMessage(Color.C(FormattedMessage));
    }
}
