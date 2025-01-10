package commandercortex.pixelperms.Local.Commands;

import commandercortex.pixelperms.Local.Permissions.GroupManager;
import commandercortex.pixelperms.Local.Players.Messages.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {

    GroupManager groupManager = new GroupManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("Error, This is a player command!");

        assert sender instanceof Player;
        Player player = (Player) sender;

        String DisplayName = args[0];

        if(!player.hasPermission("local.nick")){
            Messages.Message(player, "&cError this command requires Nick Permissions!");
        }else{
            player.setDisplayName(DisplayName);
            groupManager.TabListManager();

        }
        return false;
    }
}
