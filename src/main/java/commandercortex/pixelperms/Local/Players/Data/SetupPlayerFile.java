package commandercortex.pixelperms.Local.Players.Data;

import commandercortex.pixelperms.Local.Folders.FolderLocations;
import commandercortex.pixelperms.Local.Players.Messages.Messages;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

public class SetupPlayerFile extends FolderLocations {
    public int NewPlayerFile(Player player){
        //Defines the name & location for our new player file
        String PlayerFilerLocation = "plugins/PixelPerms/players/" + player.getUniqueId() + ".yml";

        File PlayerFile = new File(PlayerFilerLocation);
        if(!PlayerFile.exists()){
            try {
                PlayerFile.createNewFile();} catch (IOException e) {throw new RuntimeException(e);}
        } // Attempts to create a new file, on failure - the console should print why etc.

        //Creates a Yml configuration table in memory for managing our player data inside the file
        YamlConfiguration PlayerData = YamlConfiguration.loadConfiguration(PlayerFile);

        //Next section adds default Data pathways we want to store our data in.

        PlayerData.addDefault("Name:", player.getName());
        PlayerData.addDefault("Nickname:", player.getDisplayName());
        PlayerData.addDefault("Group:", ""); //Groups can be implemented as both Strings & Integers

        PlayerData.addDefault("Coins:", 0); //Example for if you require a currency system here, otherwise you can use vault etc.

        PlayerData.options().copyDefaults(true); // Sets the above preset data to always copy by default.

        try {
            PlayerData.save(PlayerFile);} catch (IOException e) {throw new RuntimeException(e);
        } // Attempts to save the above data in our new Player Data folder @ UUID.yml etc.

        Messages.Message(player, "You're Player Data has been updated"); //Notifies player of the update, Not required.

        return 0;
    }
}
