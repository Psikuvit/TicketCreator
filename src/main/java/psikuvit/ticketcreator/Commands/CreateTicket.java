package psikuvit.ticketcreator.Commands;

import net.dv8tion.jda.api.entities.Guild;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import psikuvit.ticketcreator.Main;
import psikuvit.ticketcreator.Utils.TicketManager;
import psikuvit.ticketcreator.Utils.Utils;

public class CreateTicket implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if (!TicketManager.check(p)) {
                p.sendMessage(Utils.color("&cYou have a running ticket"));
                return true;
            }
            p.sendMessage(Utils.color("&cType /tickettoggle to switch on and off the ticket and mc chat"));

        }
        return false;
    }
}
