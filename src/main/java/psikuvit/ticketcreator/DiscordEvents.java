package psikuvit.ticketcreator;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import psikuvit.ticketcreator.Utils.TicketManager;

import java.util.UUID;

public class DiscordEvents extends ListenerAdapter implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (TicketManager.checkOpener(p)) {
            if (TicketManager.getPlayerChat().get(p)) {
                Ticket ticket = TicketManager.findByPlayer(p);
                e.setCancelled(true);
                TextChannel textChannel = Main.getJda().getTextChannelById(ticket.getTicketID());
                textChannel.sendMessage(e.getMessage()).queue();

            }
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Ticket ticket = TicketManager.findByID(event.getChannel().asTextChannel());
        Player p = Bukkit.getPlayer(ticket.getTicketOpener());
        p.sendMessage(event.getMessage().getContentRaw());

    }
}
