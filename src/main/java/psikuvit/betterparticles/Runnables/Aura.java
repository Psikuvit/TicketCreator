package psikuvit.betterparticles.Runnables;

import psikuvit.betterparticles.Main;
import psikuvit.betterparticles.ParticleEffects;
import psikuvit.betterparticles.Utils.MathParticles;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Aura extends BukkitRunnable {
    private HashMap<Player, Integer> auracount = new HashMap<>();

    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (Main.getParticleEffectItem(p) != null)
                for (ParticleEffects pe : Main.getParticleEffectItem(p)) {
                    if (pe.getShape().equals("aura")) {
                        float rgb1 = MathParticles.getRGB(1, pe);
                        float rgb2 = MathParticles.getRGB(2, pe);
                        float rgb3 = MathParticles.getRGB(3, pe);
                        if (this.auracount.get(p) == null)
                            this.auracount.put(p, Integer.valueOf(3));
                        MathParticles.playCircle(p, p.getLocation().add(0.0D, (((Integer)this.auracount.get(p)).intValue() / 10.0F), 0.0D), pe, 1.0D,
                                rgb1, rgb2, rgb3);
                        this.auracount.put(p, Integer.valueOf(((Integer)this.auracount.get(p)).intValue() + 3));
                        if (((Integer)this.auracount.get(p)).intValue() == 18)
                            this.auracount.put(p, Integer.valueOf(3));
                    }
                }
        }
    }
}
