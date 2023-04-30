package psikuvit.ticketcreator;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import psikuvit.ticketcreator.Utils.JDAMethods;
import psikuvit.ticketcreator.Utils.TicketManager;

public class DiscordEvents extends ListenerAdapter implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (TicketManager.checkOpener(p)) {
            if (TicketManager.getPlayerChat().get(p)) {
                Ticket ticket = TicketManager.findByPlayer(p);
                e.setCancelled(true);
                TextChannel textChannel = JDAMethods.getTextChannelByID(ticket.getTicketID());
                textChannel.sendMessage(e.getMessage()).queue();

            }
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        TextChannel textChannel = JDAMethods.getTextChannelByID(event.getChannel().asTextChannel().getId());
        if (event.getMessage().getContentRaw().equalsIgnoreCase("ticket delete")) {
            textChannel.delete().queue();
        } else {
            Ticket ticket = TicketManager.findByID(textChannel);
            Player p = Bukkit.getPlayer(ticket.getTicketOpener());
            p.sendMessage(event.getMessage().getContentRaw());
        }
    }
}
