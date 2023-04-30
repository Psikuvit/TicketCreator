package psikuvit.ticketcreator.Commands.args;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import psikuvit.ticketcreator.Commands.CommandAbstract;
import psikuvit.ticketcreator.Main;
import psikuvit.ticketcreator.Utils.TicketManager;
import psikuvit.ticketcreator.Utils.Utils;

public class TicketCreatorArg extends CommandAbstract {
    public TicketCreatorArg(Main plugin) {
        super(plugin);
    }

    @Override
    public void executeCommand(String[] p0, CommandSender sender) {
        if (sender instanceof Player p) {
            if (!TicketManager.checkOpener(p)) {
                TicketManager.createTicket(p);
                TicketManager.getPlayerChat().put(p, true);
            } else {
                p.sendMessage(Utils.color("&cYou have a running ticket"));
                return;
            }
            p.sendMessage(Utils.color("&cType /tickettoggle to switch on and off the ticket and mc chat"));

        }

    }

    @Override
    public String correctArg() {
        return "ticket create";
    }

    @Override
    public boolean onlyPlayer() {
        return true;
    }

    @Override
    public int requiredArg() {
        return 0;
    }
}
