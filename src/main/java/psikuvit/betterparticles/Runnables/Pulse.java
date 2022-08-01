package psikuvit.betterparticles.Runnables;

import psikuvit.betterparticles.Main;
import psikuvit.betterparticles.ParticleEffects;
import psikuvit.betterparticles.Utils.MathParticles;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class Pulse extends BukkitRunnable {
    private HashMap<Player, Double> pulsecount = new HashMap<>();

    private ArrayList<Player> mode = new ArrayList<>();

    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (Main.getParticleEffectItem(p) != null)
                for (ParticleEffects pe : Main.getParticleEffectItem(p)) {
                    if (pe.getShape().equals("pulse")) {
                        float rgb1 = MathParticles.getRGB(1, pe);
                        float rgb2 = MathParticles.getRGB(2, pe);
                        float rgb3 = MathParticles.getRGB(3, pe);
                        if (this.pulsecount.get(p) == null)
                            this.pulsecount.put(p, Double.valueOf(5.0D));
                        for (int i = 5; i < ((Double)this.pulsecount.get(p)).doubleValue(); i += 5)
                            MathParticles.playCircle(p, p.getLocation(), pe, i / 10.0D, rgb1, rgb2, rgb3);
                        if (((Double)this.pulsecount.get(p)).doubleValue() == 25.0D)
                            this.mode.add(p);
                        if (((Double)this.pulsecount.get(p)).doubleValue() == 0.0D)
                            this.mode.remove(p);
                        if (this.mode.contains(p))
                            this.pulsecount.put(p, Double.valueOf(((Double)this.pulsecount.get(p)).doubleValue() - 5.0D));
                        if (!this.mode.contains(p))
                            this.pulsecount.put(p, Double.valueOf(((Double)this.pulsecount.get(p)).doubleValue() + 5.0D));
                    }
                }
        }
    }
}
