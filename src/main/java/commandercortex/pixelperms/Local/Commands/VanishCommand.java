package commandercortex.pixelperms.Local.Commands;

import commandercortex.pixelperms.Local.Permissions.GroupManager;
import commandercortex.pixelperms.Local.Players.Messages.Messages;
import commandercortex.pixelperms.PixelPerms;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class VanishCommand implements CommandExecutor {
    GroupManager groupManager = new GroupManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Error, This is a Player Command!");
            return false;
        }

        Player player = (Player) sender;
        Plugin plugin = PixelPerms.getPlugin(PixelPerms.class);

        if(!player.hasPermission("local.vanish")) {
            Messages.Message(player, "&aError, You do not have permission to use this command");
        }
        if(!player.isInvisible()) {
            player.setInvisible(true);
            player.setGameMode(GameMode.SPECTATOR);
            player.hidePlayer(plugin, player);
            groupManager.TabListManager();
            Messages.Message(player, "You're now vanished");
        }else {
            player.setInvisible(false);
            player.setGameMode(GameMode.SURVIVAL);
            player.showPlayer(plugin, player);
            groupManager.TabListManager();
            Messages.Message(player, "You're not longer hidden");
        }

        return false;
    }
}
