package commandercortex.pixelperms.Local.Folders;

import java.io.File;

public class FolderManager extends FolderLocations{
    public int Create_PixelPerms_Folder(){
        File _PixelPerms = new File(PixelPerms_Folder);
        if(!_PixelPerms.exists())
            _PixelPerms.mkdir();
        System.out.println("[PixelPerms] -> Verifying integrity of: \"plugins/PixelPerms/\"");
        return 0;
        //Creates a folder @ "plugins/PixelPerms/" if one is missing on startup
    }
    public int Create_Player_Folder(){
        File _PlayerFolder = new File(Player_Folder);
        if(!_PlayerFolder.exists())
            _PlayerFolder.mkdir();
        System.out.println("[PixelPerms] -> Verifying integrity of: \"plugins/PixelPerms/players/\"");
        return 0;
        //Creates a folder @ "plugins/PixelPerms/players/" if one is missing on startup
    }
}
