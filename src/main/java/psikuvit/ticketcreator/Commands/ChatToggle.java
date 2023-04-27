package psikuvit.ticketcreator.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import psikuvit.ticketcreator.Utils.TicketManager;
import psikuvit.ticketcreator.Utils.Utils;

public class ChatToggle implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (!TicketManager.checkOpener(p)) {
                p.sendMessage(Utils.color("&cYou dont have a existing ticket to use this command"));
                return true;
            }
            if (TicketManager.getPlayerChat().get(p)) {
                TicketManager.getPlayerChat().put(p, false);
            } else {
                TicketManager.getPlayerChat().put(p, true);
            }
        }
        return false;
    }
}
