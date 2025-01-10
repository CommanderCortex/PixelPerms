package commandercortex.pixelperms.Local.Commands;

import commandercortex.pixelperms.Local.Players.Messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("Error, this is a player command");

        assert sender instanceof Player;
        Player player = (Player) sender;

        if(!player.hasPermission("local.broadcast")) {
            Messages.Message(player, "&cError, this Command requires Mod");
        }else
            Bukkit.broadcastMessage(Messages.C(Messages.prefix+ Arrays.toString(args)));
        return false;
    }
}
