package psikuvit.ticketcreator.Utils;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import psikuvit.ticketcreator.Main;

public class JDAMethods {

    static JDA jda = Main.getJda();

    public static Guild getGuild(String id) {
        return jda.getGuildById(id);
    }
}
