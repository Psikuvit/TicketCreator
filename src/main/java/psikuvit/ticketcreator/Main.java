package psikuvit.ticketcreator;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin implements Listener {

    static Main plugin;
    static JDA jda;

    @Override
    public void onEnable() {
        plugin = this;
        jda = JDABuilder.createDefault(getConfig().getString("BotToken"))
                .addEventListeners(new DiscordEvents())
                .build();

        // Register listener for Spigot events
        saveConfig();

    }

    @Override
    public void onDisable() {

    }

    public static Main getPlugin() {
        return plugin;
    }

    public static JDA getJda() {
        return jda;
    }
}
