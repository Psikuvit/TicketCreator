package psikuvit.ticketcreator.Utils;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.entity.Player;
import psikuvit.ticketcreator.Main;
import psikuvit.ticketcreator.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketManager {

    static Main plugin = Main.getPlugin();
    static List<Ticket> ticketList = new ArrayList<>();
    static HashMap<Player, Boolean> playerChat = new HashMap<>();

    public static Ticket findByID(TextChannel id) {
        for (Ticket ticket : getTicketList()) {
            if (ticket.getTicketID().equalsIgnoreCase(id.getId())) {
                return ticket;
            }
        }
        return null;
    }

    public static Ticket findByPlayer(Player p) {
        for (Ticket ticket : getTicketList()) {
            if (ticket.getTicketOpener() == p.getUniqueId()) {
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
        Guild guild = JDAMethods.getGuild();
        String id = "ticket-" + p.getDisplayName();
        guild.createTextChannel(id).setName(id).queue();

        TextChannel textChannel = JDAMethods.getTextChannelByName(id);
        if (textChannel == null) {
            return;
        }
        Ticket ticket = new Ticket(p.getUniqueId(), textChannel.getId());
        TicketManager.addTicket(ticket);
        p.sendMessage(Utils.color("&bticket with ID: " + ticket.getTicketID() + " &bwas created"));
    }

    public static List<Ticket> getTicketList() {
        return ticketList;
    }
    public static boolean checkOpener(Player player) {
        for (Ticket ticket : getTicketList()) {
            return ticket.getTicketOpener() == player.getUniqueId();
        }
        return false;
    }
    public static HashMap<Player, Boolean> getPlayerChat() {
        return playerChat;
    }
}
