package commandercortex.pixelperms.Local.Players.Events;

import commandercortex.pixelperms.Local.Permissions.GroupManager;
import commandercortex.pixelperms.Local.Permissions.PermissionsByGroup.SetPermissionNodes;
import commandercortex.pixelperms.Local.Players.Data.SetupPlayerFile;
import commandercortex.pixelperms.Local.Players.Messages.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoinEvent implements Listener {
    GroupManager groupManager = new GroupManager();
    SetPermissionNodes setPermissionNodes = new SetPermissionNodes();

    SetupPlayerFile setupPlayerFile = new SetupPlayerFile();
    //We want a Localised object of this function (Never us static) as to create a new function for each player etc... - prevents memory leaks.
    @EventHandler
    public int onPlayerJoin(PlayerJoinEvent JoinEvent){
        // Loads the player as an object into memory once they join the server
        Player player = JoinEvent.getPlayer();

        //Use the setup function in SetupPlayerFile to create a new file if they need one.
        setupPlayerFile.NewPlayerFile(player);

        //Custom Join Message:
        JoinEvent.setJoinMessage(""); //this is a global broadcast message btw

        //Update the local players tab-list
        groupManager.TabListManager();

        //Add Relevant Permission Nodes
        setPermissionNodes.setPermissionNodes(player);

        //Private Join Message:
        Messages.Message(player,"&aWelcome to this Server!");

        return 0;
    }
}
