package commandercortex.pixelperms.Local.Permissions.PermissionsByGroup;

import commandercortex.pixelperms.Local.Permissions.GroupManager;
import commandercortex.pixelperms.Local.Permissions.PermissionsManager;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class SetPermissionNodes extends GroupManager {

    public void setGroupManagerPerms(Player player){
        //Group Manager Permissions
        PermissionsManager.addPermission(player.getUniqueId(), "local.group.set.dev");
        PermissionsManager.addPermission(player.getUniqueId(), "local.group.set.admin");
        PermissionsManager.addPermission(player.getUniqueId(), "local.group.set.srmod");
        PermissionsManager.addPermission(player.getUniqueId(), "local.group.set.mod");
        PermissionsManager.addPermission(player.getUniqueId(), "local.group.set.trainee");
        PermissionsManager.addPermission(player.getUniqueId(), "local.group.set.default");
    }

    public void setDevPerms(Player player){
        //Bukkit Debugging Commands
        PermissionsManager.addPermission(player.getUniqueId(), "bukkit.command.reload");
        PermissionsManager.addPermission(player.getUniqueId(), "bukkit.command.timings");

        //Default Minecraft Commands
        PermissionsManager.addPermission(player.getUniqueId(), "minecraft.command.debug");
    }

    public void setAdminPerms(Player player){
        //Default Minecraft Commands
        PermissionsManager.addPermission(player.getUniqueId(), "minecraft.command.gamemode");
        //Local Plugin Permissions
        PermissionsManager.addPermission(player.getUniqueId(), "local.gamemode");
    }

    public void setModPerms(Player player){
        //Local Plugin Permissions
        PermissionsManager.addPermission(player.getUniqueId(), "local.fly");
        PermissionsManager.addPermission(player.getUniqueId(), "local.vanish");
        PermissionsManager.addPermission(player.getUniqueId(), "local.broadcast");
        PermissionsManager.addPermission(player.getUniqueId(), "local.nick");
    }

    public void setPermissionNodes(Player player){

        if(Objects.equals(getGroup(player), "Developer")) {
            setGroupManagerPerms(player);
            setDevPerms(player);
            setAdminPerms(player);
            setModPerms(player);

        }
        if (Objects.equals(getGroup(player), "Admin")) {
            setGroupManagerPerms(player);
            setAdminPerms(player);
            setModPerms(player);
        }
        if (Objects.equals(getGroup(player), "Sr.Mod")) {
            setModPerms(player);
        }
        if (Objects.equals(getGroup(player), "Mod")) {
            setModPerms(player);
        }
        if (Objects.equals(getGroup(player), "Trainee")) {
            setModPerms(player);
        }
        if (Objects.equals(getGroup(player), "Default")) {
            PermissionsManager.removePermission(player.getUniqueId(), "bukkit.command.plugins");
            PermissionsManager.removePermission(player.getUniqueId(), "bukkit.command.version");
        }
    }
}
