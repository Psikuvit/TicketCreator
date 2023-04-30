package psikuvit.ticketcreator;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import psikuvit.ticketcreator.Commands.CommandRegisterer;


public class Main extends JavaPlugin implements Listener {

    static Main plugin;
    static JDA jda;

    @Override
    public void onEnable() {
        plugin = this;
        jda = JDABuilder.createDefault(getConfig().getString("BotToken"))
                .addEventListeners(new DiscordEvents())
                .build();
        Message.suppressContentIntentWarning();

        // Register listener for Spigot events
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new DiscordEvents(), this);
        getCommand("ticket").setExecutor(new CommandRegisterer(this));

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
