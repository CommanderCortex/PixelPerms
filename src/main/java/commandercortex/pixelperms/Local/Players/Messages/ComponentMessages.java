package commandercortex.pixelperms.Local.Players.Messages;

import commandercortex.pixelperms.Global.Components.BaseTextComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;

import java.awt.*;

public class ComponentMessages {

    String text;

    public void Message(){
        TextComponent textComponent = BaseTextComponent.LinkBaseTextComponent(ChatColor.translateAlternateColorCodes('&', text), "", "");
    }

}
