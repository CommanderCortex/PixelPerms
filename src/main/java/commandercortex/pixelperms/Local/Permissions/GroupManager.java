package commandercortex.pixelperms.Local.Permissions;

import commandercortex.pixelperms.Local.Players.Data.GetPlayerData;
import commandercortex.pixelperms.Local.Players.Messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GroupManager extends Groups{
    public String getGroup(Player player){ //Function to return the String value of a users group
        String file = GetPlayerData.getPlayer(player); //opens the players data file
        File playerFile = new File(file); //Creates a new local file to read
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(playerFile); // appends it as a Yml type table
        return yaml.getString("Group:"); //returns the String located under "Group:"
    }
    public void setGroup(Player player, String group){ //Function to set the String value of a users group
        String file = GetPlayerData.getPlayer(player);  //opens the players data file
        File playerFile = new File(file); //Creates a new local file to read
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(playerFile); // appends it as a Yml type table
        yaml.set("Group:", group); //Sets the group vault to our parameter
        try {yaml.save(file);} catch (IOException e) {throw new RuntimeException(e);} // Attempts to save the file
    }
    public String GroupPrefix(String group){
        if(Objects.equals(group, Developer)) {
            return Messages.C("&7[&4&lDEV&r&7] &r");
        }else if(Objects.equals(group, Admin)) {
            return Messages.C("&7[&4&lADMIN&r&7] &r");
        }
        return "";
    }
    public int TabListManager(){
        for(Player player : Bukkit.getOnlinePlayers()){
            Scoreboard scoreboard = Objects.requireNonNull(Bukkit.getScoreboardManager()).getNewScoreboard();
            for (Player player1 : Bukkit.getOnlinePlayers()){
                String prefix = GroupPrefix(getGroup(player));
                Team team = scoreboard.registerNewTeam(player1.getDisplayName());
                team.setPrefix(prefix);
                team.addEntry(player1.getDisplayName());
            }
            player.setScoreboard(scoreboard);
        }
        return 0;
    }
}
