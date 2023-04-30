package psikuvit.ticketcreator.Commands;

import org.bukkit.command.CommandSender;
import psikuvit.ticketcreator.Main;

public abstract class CommandAbstract
{
    protected Main plugin;

    public CommandAbstract(final Main plugin) {
        this.plugin = plugin;
    }

    public abstract void executeCommand(final String[] p0, final CommandSender p1);

    public abstract String correctArg();

    public abstract boolean onlyPlayer();

    public abstract int requiredArg();
}