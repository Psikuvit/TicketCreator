package psikuvit.ticketcreator.Utils;

import net.dv8tion.jda.api.entities.Guild;
import org.bukkit.entity.Player;
import psikuvit.ticketcreator.Main;
import psikuvit.ticketcreator.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {

    static Main plugin = Main.getPlugin();
    static List<Ticket> ticketList = new ArrayList<>();

    public static Ticket findByID(String id) {
        for (Ticket ticket : getTicketList()) {
            if (ticket.getTicketID().equalsIgnoreCase(id)) {
                return ticket;
            }
        }
        return null;
    }

    public static void addTicket(Ticket ticket) {
        getTicketList().add(ticket);
    }
    public static void removeTicket(Ticket ticket) {
        getTicketList().remove(ticket);
    }

    public static void createTicket(Player p) {
        Guild guild = JDAMethods.getGuild(plugin.getConfig().getString("Guild"));
        String id = "ticket-" + p.getDisplayName();
        guild.createTextChannel(id).queue();
        Ticket ticket = new Ticket(p.getUniqueId(), id);
        TicketManager.addTicket(ticket);
    }

    public static List<Ticket> getTicketList() {
        return ticketList;
    }
    public static boolean check(Player player) {
        for (Ticket ticket : getTicketList()) {
            return ticket.getTicketOpener() == player.getUniqueId();
        }
        return false;
    }
}
