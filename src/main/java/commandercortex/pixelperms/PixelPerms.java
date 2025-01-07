package commandercortex.pixelperms;

import commandercortex.pixelperms.Global.Chat.OnChatEvent;
import commandercortex.pixelperms.Local.Commands.FlyCommand;
import commandercortex.pixelperms.Local.Commands.GroupCommand;
import commandercortex.pixelperms.Local.Folders.FolderManager;
import commandercortex.pixelperms.Local.Players.Events.onPlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PixelPerms extends JavaPlugin {
    FolderManager folderManager = new FolderManager(); //Localised object for a once off use of these functions, (Better on memory)


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Starting Pixel Permissions System [Alpha]");

        //Load our file manager into server space
        folderManager.Create_PixelPerms_Folder();
        folderManager.Create_Player_Folder();

        //Load our Events into Memory:
        Events();
        Commands();

    }

    public void Events(){
        //Each event needs to be called below then loaded once in onEnable ...
        Bukkit.getPluginManager().registerEvents(new onPlayerJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnChatEvent(), this);
    }
    public void Commands(){
        Objects.requireNonNull(Bukkit.getPluginCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("group")).setExecutor(new GroupCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
