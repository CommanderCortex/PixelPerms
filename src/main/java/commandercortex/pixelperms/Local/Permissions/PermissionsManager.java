package commandercortex.pixelperms.Local.Permissions;

import commandercortex.pixelperms.Local.Players.Messages.Messages;
import commandercortex.pixelperms.PixelPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class PermissionsManager {

    private static PermissionAttachment fetchPlayer(UUID uuid){
        Plugin plugin = PixelPerms.getPlugin(PixelPerms.class);
        Player player = Bukkit.getPlayer(uuid);
        if (player != null){
            return player.addAttachment(plugin);
        }
        else{
            return null;
        }

    }

    public static void addPermission(UUID uuid, String permission){
        PermissionAttachment perm = fetchPlayer(uuid);
        assert perm != null;
        perm.setPermission(permission, true);
    }

    public static void removePermission(UUID uuid, String permission){
        PermissionAttachment perm = fetchPlayer(uuid);
        assert perm != null;
        perm.unsetPermission(permission);
    }
}
