package psikuvit.ticketcreator.Commands.args;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import psikuvit.ticketcreator.Commands.CommandAbstract;
import psikuvit.ticketcreator.Main;
import psikuvit.ticketcreator.Ticket;
import psikuvit.ticketcreator.Utils.JDAMethods;
import psikuvit.ticketcreator.Utils.TicketManager;

public class TicketDeleteArg extends CommandAbstract {
    public TicketDeleteArg(Main plugin) {
        super(plugin);
    }

    @Override
    public void executeCommand(String[] p0, CommandSender sender) {
        if (sender instanceof Player p) {
            Ticket ticket = TicketManager.findByPlayer(p);
            TextChannel textChannel = JDAMethods.getTextChannelByID(ticket.getTicketID());
            textChannel.delete().queue();
        }

    }

    @Override
    public String correctArg() {
        return "ticket delete";
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
