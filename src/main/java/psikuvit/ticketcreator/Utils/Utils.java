package psikuvit.ticketcreator.Utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public static List<String> color(List<String> msg) {
        return msg.stream().map(Utils::color).collect(Collectors.toList());
    }
}
