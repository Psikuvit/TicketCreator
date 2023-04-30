package psikuvit.ticketcreator.Commands.args;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import psikuvit.ticketcreator.Commands.CommandAbstract;
import psikuvit.ticketcreator.Main;
import psikuvit.ticketcreator.Utils.TicketManager;
import psikuvit.ticketcreator.Utils.Utils;

public class ChatToggleArg extends CommandAbstract {
    public ChatToggleArg(Main plugin) {
        super(plugin);
    }

    @Override
    public void executeCommand(String[] p0, CommandSender sender) {
        if (sender instanceof Player p) {
            if (!TicketManager.checkOpener(p)) {
                p.sendMessage(Utils.color("&cYou dont have a existing ticket to use this command"));
                return;
            }
            if (TicketManager.getPlayerChat().get(p)) {
                TicketManager.getPlayerChat().put(p, false);
            } else {
                TicketManager.getPlayerChat().put(p, true);
            }
        }
    }

    @Override
    public String correctArg() {
        return "ticket toggle";
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
