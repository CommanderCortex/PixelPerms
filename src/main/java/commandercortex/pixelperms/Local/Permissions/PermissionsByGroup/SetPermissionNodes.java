package commandercortex.pixelperms.Local.Permissions.PermissionsByGroup;

import commandercortex.pixelperms.Local.Permissions.GroupManager;
import commandercortex.pixelperms.Local.Permissions.PermissionsManager;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SetPermissionNodes extends GroupManager {
    public int setPermissionNodes(Player player){
        if(Objects.equals(getGroup(player), "Developer")) {
            //Bukkit Debugging Commands
            PermissionsManager.addPermission(player.getUniqueId(), "bukkit.command.reload");
            PermissionsManager.addPermission(player.getUniqueId(), "bukkit.command.timings");

            //Default Minecraft Commands
            PermissionsManager.addPermission(player.getUniqueId(), "minecraft.command.debug");
            PermissionsManager.addPermission(player.getUniqueId(), "minecraft.command.gamemode");

            //Local Plugin Permissions
            PermissionsManager.addPermission(player.getUniqueId(), "local.fly");
            PermissionsManager.addPermission(player.getUniqueId(), "local.group.set");

        } else if (Objects.equals(getGroup(player), "Admin")) {
                //Bukkit Debugging Commands
                PermissionsManager.addPermission(player.getUniqueId(), "bukkit.command.reload");
                PermissionsManager.addPermission(player.getUniqueId(), "bukkit.command.timings");

                //Default Minecraft Commands
                PermissionsManager.addPermission(player.getUniqueId(), "minecraft.command.debug");
                PermissionsManager.addPermission(player.getUniqueId(), "minecraft.command.gamemode");

                //Local Plugin Permissions
                PermissionsManager.addPermission(player.getUniqueId(), "local.fly");
                PermissionsManager.addPermission(player.getUniqueId(), "local.group.set");

    } else if (Objects.equals(getGroup(player), null)) {
            return 0;
        }
        return 0;
    }
}
