package psikuvit.ticketcreator.Utils;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import psikuvit.ticketcreator.Main;

public class JDAMethods {

    static Main plugin = Main.getPlugin();

    static JDA jda = Main.getJda();

    static Guild guild = jda.getGuildById(plugin.getConfig().getString("Guild"));

    public static TextChannel getTextChannelByName(String channelName) {
        for (TextChannel textChannel : getGuild().getTextChannels()) {
            if (textChannel.getName().equalsIgnoreCase(channelName))
                return textChannel;
        }
        return null;
    }
    public static TextChannel getTextChannelByID(String channelID) {
        for (TextChannel textChannel : getGuild().getTextChannels()) {
            if (textChannel.getId().equalsIgnoreCase(channelID))
                return textChannel;
        }
        return null;
    }

    public static Guild getGuild() {
        return guild;
    }
}
