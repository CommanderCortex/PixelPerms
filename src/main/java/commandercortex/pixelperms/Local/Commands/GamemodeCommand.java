package commandercortex.pixelperms.Local.Commands;

import commandercortex.pixelperms.Local.Players.Messages.Messages;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("Error, This is a player command!");

        assert sender instanceof Player;
        Player player = (Player) sender;

        if(!player.hasPermission("local.gamemode")) {
            Messages.Message(player, "&cError, this command requires Builder");
            return false;
        }

        if(!player.getGameMode().equals(GameMode.CREATIVE)) {
            player.setGameMode(GameMode.CREATIVE);
            Messages.Message(player, "&aYou're Gamemode has been updated to Creative");
        }else {
            player.setGameMode(GameMode.SURVIVAL);
            Messages.Message(player, "&aYou're Gamemode has been updated to survival");
        }

        return false;
    }
}
