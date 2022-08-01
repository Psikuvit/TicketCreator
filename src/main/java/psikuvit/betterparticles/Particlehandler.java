package psikuvit.betterparticles;

import psikuvit.betterparticles.Utils.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class Particlehandler implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sparticles")) {
            Player p = (Player)sender;
            if (!p.hasPermission("op")) {
                p.sendMessage("don't have the permission to do this command.");
                return false;
            }
            if (sender instanceof Player)
                if (args.length == 0) {
                    openPrincipalGui(p, 1);
                } else if (args.length == 1) {
                    ItemStack getitem = p.getInventory().getItemInHand();
                    if (args[0].equals("amount")) {
                        p.sendMessage("§cIf you want to modify the amount of your particles, use the command modifyamount <id> <amountofparticles>§c.");
                        return false;
                    }
                    for (ParticleEffects particleEffect : Main.listparticleeffect) {
                        if (particleEffect.getId().equals(args[0])) {
                            p.sendMessage("§cID already taken !");
                            return false;
                        }
                    }
                    String name = null;
                    List<String> lore = null;
                    Material type = getitem.getType();
                    if (getitem.hasItemMeta() && getitem.getItemMeta().getDisplayName() != null)
                        name = getitem.getItemMeta().getDisplayName();
                    if (getitem.hasItemMeta() && getitem.getItemMeta().getLore() != null)
                        lore = getitem.getItemMeta().getLore();
                    ParticleEffects pe = new ParticleEffects(name, lore, type, args[0], null, null, Integer.valueOf(0), null, null, null);
                    Main.listparticleeffect.add(pe);
                    p.sendMessage("§cYou created a new item particle !");
                    openPrincipalGui(p, 1);
                } else if (args[0].equals("amount")) {
                    for (ParticleEffects pe : Main.listparticleeffect) {
                        if (pe.getId().equals(args[1])) {
                            try {
                                int i = Integer.parseInt(args[2]);
                            } catch (NumberFormatException|NullPointerException nfe) {
                                p.sendMessage("§cWrong arguments ! write numbers");
                                return false;
                            }
                            pe.setAmount(Integer.parseInt(args[2]));
                            p.sendMessage("§cThe amount of particles has been set on §3" + args[2] + ".");
                            return false;
                        }
                    }
                    p.sendMessage("no particle found with this id !");
                } else if (args[0].equals("permission")) {
                    for (ParticleEffects pe : Main.listparticleeffect) {
                        if (pe.getId().equals(args[1])) {
                            pe.setPermission(args[2]);
                            p.sendMessage("§cThe permission of the effect §d" + pe.getId() + " §chas been set on §b" + args[2] + ".");
                            return false;
                        }
                    }
                    p.sendMessage("§cNo particle found with this id !");
                } else {
                    p.sendMessage("§cWrong arguments !");
                }
        }
        return false;
    }

    public static ItemStack getItemStack(String name, List<String> lore, Material type) {
        ItemStack is = new ItemStack(type);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public static void openPrincipalGui(Player p, int page) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_BLUE + "Particles Menu");
        int i = 1;
        if (page != 1)
            i = 0;
        int numberinthelist = 0;
        if (page == 1)
            inv.setItem(0, getItemStack("§cCreate a new item particle", null, XMaterial.BLAZE_ROD.parseMaterial()));
        for (ParticleEffects pe : Main.listparticleeffect) {
            if (page != 1 &&
                    numberinthelist < 52 * (page - 1)) {
                numberinthelist++;
                continue;
            }
            ItemStack is = new ItemStack(XMaterial.MAGMA_CREAM.parseMaterial());
            ItemMeta im = is.getItemMeta();
            if (pe.getId() != null)
                im.setDisplayName("§d§l" + pe.getId());
                        String name = "none";
            String type = "none";
            String lore = "none";
            if (pe.getName() != null)
                name = pe.getName();
            if (pe.getItem() != null)
                type = pe.getItem().toString();
            if (pe.getLore() != null)
                lore = "set";
            im.setLore(Arrays.asList(new String[] { "name: " + name,
                    "§b§lItem type: " + type,
                    "§b§lItem lore: " + lore,
                    String.valueOf(numberinthelist)}));
            is.setItemMeta(im);
            inv.setItem(i, is);
            if (i == 52) {
                ItemStack nextpage = new ItemStack(XMaterial.PAPER.parseItem());
                ItemMeta pagemeta = nextpage.getItemMeta();
                pagemeta.setDisplayName("§c>Page" + (page + 1));
                nextpage.setItemMeta(pagemeta);
                inv.setItem(53, nextpage);
                break;
            }
            i++;
            numberinthelist++;
        }
        p.openInventory(inv);
        p.updateInventory();
    }
}