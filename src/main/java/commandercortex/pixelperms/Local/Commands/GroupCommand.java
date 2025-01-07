package commandercortex.pixelperms.Local.Commands;

import commandercortex.pixelperms.Local.Permissions.GroupManager;
import commandercortex.pixelperms.Local.Players.Messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GroupCommand implements CommandExecutor {
    GroupManager groupManager = new GroupManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("Error, This is a player command");

        assert sender instanceof Player;
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if (target == null || !target.isOnline()) {
            Messages.Message(player, "&cError, Player Not Found?!");
            return false;
        }

        switch (args[1]){
            case "developer":
                if(player.hasPermission("local.group.set")){
                    groupManager.setGroup(target, "Developer");
                    Messages.Message(player, "Set " + target.getDisplayName() + "'s group to Developer");
                    groupManager.TabListManager();
                }else {
                    Messages.Message(player, "&cError, This Command requires Administrator Permissions!");
                }
                break;
            case "admin":
                if(player.hasPermission("local.group.set")){
                    groupManager.setGroup(target, "Admin");
                    Messages.Message(player, "Set " + target.getDisplayName() + "'s group to Admin");
                    groupManager.TabListManager();
                }else {
                    Messages.Message(player, "&cError, This Command requires Administrator Permissions!");
                }
                break;
            case "default":
                if(player.hasPermission("local.group.set")){
                    groupManager.setGroup(target, "");
                    Messages.Message(player, "Set " + target.getDisplayName() + "'s group to default");
                    groupManager.TabListManager();
                }else {
                    Messages.Message(player, "&cError, This Command requires Administrator Permissions!");
                }
                break;
            default:
                Messages.Message(player, "&cError, Unable to process request");
        }

        return false;
    }
}
