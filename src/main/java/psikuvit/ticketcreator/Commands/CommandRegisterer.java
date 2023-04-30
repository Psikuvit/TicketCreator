package psikuvit.ticketcreator.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import psikuvit.ticketcreator.Commands.args.ChatToggleArg;
import psikuvit.ticketcreator.Commands.args.TicketCreatorArg;
import psikuvit.ticketcreator.Main;
import psikuvit.ticketcreator.Utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class CommandRegisterer implements CommandExecutor {
    private final Map<String, CommandAbstract> commandAbstractMap;

    public CommandRegisterer(final Main plugin) {
        this.commandAbstractMap = new HashMap<>();
        commandAbstractMap.put("toggle", new ChatToggleArg(plugin));
        commandAbstractMap.put("create", new TicketCreatorArg(plugin));

    }

    public boolean onCommand(final CommandSender commandSender, final Command command, final String label, String[] args) {
        if (args.length == 0) {
            return true;
        }
        final String subCommand = args[0];
        boolean found = false;
        for (final String cmdAlias : this.commandAbstractMap.keySet()) {
            if (cmdAlias.equalsIgnoreCase(subCommand)) {
                final int argsCount = args.length - 1;
                final boolean isSenderPlayer = commandSender instanceof Player;
                final CommandAbstract cmd = this.commandAbstractMap.get(cmdAlias);
                if (argsCount > cmd.requiredArg()) {
                    commandSender.sendMessage(Utils.color("§cCorrect usage: §e" + cmd.correctArg()));
                    return true;
                }
                if (argsCount < cmd.requiredArg()) {
                    commandSender.sendMessage(Utils.color("§cCorrect usage: §e" + cmd.correctArg()));
                    return true;
                }
                if (!isSenderPlayer && cmd.onlyPlayer()) {
                    commandSender.sendMessage(Utils.color("§cYou need to be a player"));
                    return true;
                }
                args = this.move(args);
                cmd.executeCommand(args, commandSender);
                found = true;
                break;
            }
        }
        if (!found) {
            commandSender.sendMessage(Utils.color("§cUnknown command"));
        }
        return true;
    }

    private String[] move(final String[] args) {
        final String[] result = new String[args.length - 1];
        System.arraycopy(args, 1, result, 0, args.length - 1);
        return result;
    }
}
