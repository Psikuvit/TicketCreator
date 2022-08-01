package psikuvit.betterparticles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bstats.bukkit.Metrics;
import psikuvit.betterparticles.Listener.GUI;
import psikuvit.betterparticles.Listener.PlayerMove;
import psikuvit.betterparticles.Runnables.Aura;
import psikuvit.betterparticles.Runnables.Other;
import psikuvit.betterparticles.Runnables.Pulse;
import psikuvit.betterparticles.Runnables.Wing;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static ArrayList<ParticleEffects> listparticleeffect = new ArrayList<>();

    private final String fileName = "savedata.yml";

    private File file = new File(getDataFolder(),"savedata.yml");

    public static Plugin pl;

    public void onEnable() {
        pl = (Plugin)this;
        if (!Bukkit.getVersion().contains("1.7"))
            ConfigurationSerialization.registerClass(ParticleEffects.class, "Particle");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);
        ArrayList<ParticleEffects> deserialization = (ArrayList<ParticleEffects>)yamlConfiguration.get("arraylist");
        if (deserialization != null && deserialization.size() > 0) {
            listparticleeffect = deserialization;
        } else {
            listparticleeffect = new ArrayList<>();
        }
        this.getCommand("sparticles").setExecutor(new Particlehandler());

        getServer().getPluginManager().registerEvents(new GUI(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);

        Bukkit.getConsoleSender().sendMessage("Better Particles has been successfully Loaded!");


        (new Other()).runTaskTimer(this, 0L, 20L);
        (new Aura()).runTaskTimer(this, 0L, 4L);
        (new Pulse()).runTaskTimer(this, 0L, 4L);
        (new Wing()).runTaskTimer(this, 0L, 20L);


        int pluginId = 15944; 
        Metrics metrics = new Metrics(this, pluginId);
    }

    public void onDisable() {
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);
        yamlConfiguration.set("arraylist", listparticleeffect);
        try {
            yamlConfiguration.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<ParticleEffects> getParticleEffectItem(Player p) {
        ArrayList<ParticleEffects> al = new ArrayList<>();
        if (listparticleeffect != null && listparticleeffect.size() > 0)
            for (ParticleEffects pe : listparticleeffect) {
                if ((pe != null && pe
                        .getPermission() == null) || p.hasPermission(pe.getPermission())) {
                    for (ItemStack item : p.getInventory()) {
                        if (isSameItem(pe, item)) {
                            al.add(pe);
                        }
                    }
                }

            }
        if (al != null && al.size() > 0)
            return al;
        return null;
    }

    private static boolean isSameItem(ParticleEffects pe, ItemStack item) {
        if (pe.getItem() == null || (item == null))
            return false;
        if (item.getType() != null && item.getType() != pe.getItem())
            return false;
        if (pe.getName() != null && !isSameName(pe, item))
            return false;
        if (pe.getLore() != null && !isSameLore(pe, item))
            return false;
        if (pe.getParticle() == null)
            return false;
        if (pe.getShape() == null)
            return false;
        return true;
    }

    private static boolean isSameLore(ParticleEffects particleEffect, ItemStack compareItem) {
        if (compareItem == null)
            return false;
        if (!compareItem.hasItemMeta())
            return false;
        if (!compareItem.getItemMeta().hasLore())
            return false;
        return compareItem.getItemMeta().getLore().equals(particleEffect.getLore());
    }

    private static boolean isSameName(ParticleEffects particleEffect, ItemStack compareItem) {
        if (compareItem == null)
            return false;
        if (!compareItem.hasItemMeta())
            return false;
        if (!compareItem.getItemMeta().hasDisplayName())
            return false;
        return compareItem.getItemMeta().getDisplayName().equals(particleEffect.getName());
    }
}
