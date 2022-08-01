package psikuvit.betterparticles.Utils;

import psikuvit.betterparticles.Main;
import psikuvit.betterparticles.ParticleEffects;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.particle.ParticleEffect;

public class MathParticles {
    public static void playCircle(Player p, Location loc, ParticleEffects pe, double radius, float rgb1, float rgb2, float rgb3) {
        for (int i = 0; i < 50; i++) {
            double angle = 6.283185307179586D * i / 50.0D;
            Location point = loc.clone().add(radius * Math.sin(angle), 0.0D, radius * Math.cos(angle));
            spawnParticle(p.getWorld(), pe, point, rgb1, rgb2, rgb3, p);
        }
    }

    public static float getRGB(int whichrgb, ParticleEffects pe) {
        if (pe.getColor() == null)
            return 0.0F;
        int color = 0;
        if (whichrgb == 1)
            color = pe.getColor().getRed(); //IMNSRRRRR
        if (whichrgb == 2)
            color = pe.getColor().getGreen();
        if (whichrgb == 3)
            color = pe.getColor().getBlue();
        float rgb = (float)((color / 1000.0F) * 3.92D);
        if (rgb == 0.0F && whichrgb == 1)
            rgb = (float)(rgb + 0.001D);
        return rgb;
    }

    public static void spawnParticle(World world, ParticleEffects pe, Location point, float rgb1, float rgb2, float rgb3, Player p) {
        if (Bukkit.getVersion().contains("1.18") || Bukkit.getVersion().contains("1.17") || Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.15") || Bukkit.getVersion().contains("1.14") || Bukkit.getVersion().contains("1.13")) {
            Color color = Color.RED;
            if (pe.getColor() != null)
                color = pe.getColor();
            Particle.DustOptions dustOptions = null;
            if (pe.getParticle() == XParticle.REDSTONE)
                dustOptions = new Particle.DustOptions(color, 1.0F);
            world.spawnParticle(Particle.valueOf(pe.getParticle().name()), point.getX(), point.getY(), point.getZ(), 0, 0.0D, 0.0D, 0.0D, 1.0D, dustOptions);
        } else if (!Bukkit.getVersion().contains("1.8") && !Bukkit.getVersion().contains("1.7")) {
            world.spawnParticle(Particle.valueOf(pe.getParticle().name()), point.getX(), point.getY(), point.getZ(), 0, rgb1, rgb2, rgb3, 1.0D);
        } else {
            if (pe.getParticle() == XParticle.REDSTONE) {
                ParticleEffect.valueOf(pe.getParticle().name()).sendColor(Bukkit.getOnlinePlayers(), point, pe.getColor());
            }
            ParticleEffect.valueOf(pe.getParticle().name()).send(Bukkit.getOnlinePlayers(), point.getX(), point.getY(), point.getZ(), 0.0D, 0.0D, 0.0D, 0.01D, 1);
        }
    }

    public static void spawnTornado(final Location loc, final ParticleEffects pe, final float rgb1, final float rgb2, final float rgb3, final Player p) {
        (new BukkitRunnable() {
            int angle = 1;

            public void run() {
                int max_height = 3;
                double max_radius = 1.5D;
                int lines = 4;
                double height_increasement = 0.2D;
                double radius_increasement = max_radius / max_height;
                for (int l = 0; l < lines; l++) {
                    for (double y = 0.0D; y < max_height; y += height_increasement) {
                        double radius = y * radius_increasement;
                        double x = Math.cos(Math.toRadians((360 / lines * l) + y * 25.0D - this.angle)) * radius;
                        double z = Math.sin(Math.toRadians((360 / lines * l) + y * 25.0D - this.angle)) * radius;
                        for (int i = 0; i < 2; ) {
                            MathParticles.spawnParticle(loc.getWorld(), pe, loc.clone().add(x, y, z), rgb1, rgb2, rgb3, p);
                            i++;
                        }
                    }
                }
                this.angle++;
                if (this.angle == 10)
                    cancel();
            }
        }).runTaskTimer(Main.pl, 0L, 1L);
    }
}
