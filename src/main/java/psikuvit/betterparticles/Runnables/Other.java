package psikuvit.betterparticles.Runnables;

import psikuvit.betterparticles.Main;
import psikuvit.betterparticles.ParticleEffects;
import psikuvit.betterparticles.Utils.MathParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Other extends BukkitRunnable {
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (Main.getParticleEffectItem(p) != null && Main.getParticleEffectItem(p).size() != 0)
                for (ParticleEffects pe : Main.getParticleEffectItem(p)) {
                    float rgb1 = MathParticles.getRGB(1, pe);
                    float rgb2 = MathParticles.getRGB(2, pe);
                    float rgb3 = MathParticles.getRGB(3, pe);
                    World world = p.getWorld();
                    if (pe.getShape().equals("circle"))
                        MathParticles.playCircle(p, p.getLocation(), pe, 2.0D, rgb1, rgb2, rgb3);
                    if (pe.getShape().equals("sphere")) {
                        Location location = p.getLocation().add(0.0D, 3.5D, 0.0D);
                        for (double i = 0.0D; i <= Math.PI; i += 0.5235987755982988D) {
                            double radius = Math.sin(i);
                            double y = Math.cos(i);
                            for (double a = 0.0D; a < 6.283185307179586D; a += 0.3141592653589793D) {
                                double x = Math.cos(a) * radius;
                                double z = Math.sin(a) * radius;
                                location.add(x, y, z);
                                MathParticles.spawnParticle(world, pe, location, rgb1, rgb2, rgb3, p);
                                location.subtract(x, y, z);
                            }
                        }
                    }
                    if (pe.getShape().equals("disk")) {
                        double radius = 0.25D;
                        for (int i = 0; i < 8; i++) {
                            MathParticles.playCircle(p, p.getLocation(), pe, radius, rgb1, rgb2, rgb3);
                            radius += 0.25D;
                        }
                    }
                    if (pe.getShape().equals("star")) {
                        Location loc = p.getLocation();
                        for (int iteration = 0; iteration < 5; iteration++) {
                            double angle = 72.0D * iteration;
                            double nextAngle = 72.0D * (iteration + 2);
                            angle = Math.toRadians(angle);
                            nextAngle = Math.toRadians(nextAngle);
                            double x = Math.cos(angle) * 3.5D;
                            double z = Math.sin(angle) * 3.5D;
                            double x2 = Math.cos(nextAngle) * 3.5D;
                            double z2 = Math.sin(nextAngle) * 3.5D;
                            double deltaX = x2 - x;
                            double deltaZ = z2 - z;
                            double distance = Math.sqrt((deltaX - x) * (deltaX - x) + (deltaZ - z) * (deltaZ - z)) * 0.11D;
                            for (double d = 0.0D; d < distance - 0.1D; d += 0.02D) {
                                loc.add(x + deltaX * d, 0.0D, z + deltaZ * d);
                                MathParticles.spawnParticle(p.getWorld(), pe, loc, rgb1, rgb2, rgb3, p);
                                loc.subtract(x + deltaX * d, 0.0D, z + deltaZ * d);
                            }
                        }
                    }
                    if (pe.getShape().equals("star2")) {
                        Location loc = p.getLocation();
                        int points = 3;
                        int iteration;
                        for (iteration = 0; iteration < points; iteration++) {
                            double angle = 360.0D / points * iteration;
                            double nextAngle = 360.0D / points * (iteration + 1);
                            angle = Math.toRadians(angle);
                            nextAngle = Math.toRadians(nextAngle);
                            double x = Math.cos(angle) * 3.0D;
                            double z = Math.sin(angle) * 3.0D;
                            double x2 = Math.cos(nextAngle) * 3.0D;
                            double z2 = Math.sin(nextAngle) * 3.0D;
                            double deltaX = x2 - x;
                            double deltaZ = z2 - z;
                            double distance = 1.15D;
                            for (double d = 0.0D; d < distance - 0.1D; d += 0.05D) {
                                loc.add(x + deltaX * d, 0.1D, z + deltaZ * d);
                                MathParticles.spawnParticle(p.getWorld(), pe, loc, rgb1, rgb2, rgb3, p);
                                loc.subtract(x + deltaX * d, 0.1D, z + deltaZ * d);
                            }
                        }
                        for (iteration = 0; iteration < points; iteration++) {
                            double angle = 360.0D / points * iteration + 180.0D;
                            double nextAngle = 360.0D / points * (iteration + 1) + 180.0D;
                            angle = Math.toRadians(angle);
                            nextAngle = Math.toRadians(nextAngle);
                            double x = Math.cos(angle) * 3.0D;
                            double z = Math.sin(angle) * 3.0D;
                            double x2 = Math.cos(nextAngle) * 3.0D;
                            double z2 = Math.sin(nextAngle) * 3.0D;
                            double deltaX = x2 - x;
                            double deltaZ = z2 - z;
                            double distance = 1.15D;
                            for (double d = 0.0D; d < distance - 0.1D; d += 0.05D) {
                                loc.add(x + deltaX * d, 0.1D, z + deltaZ * d);
                                MathParticles.spawnParticle(p.getWorld(), pe, loc, rgb1, rgb2, rgb3, p);
                                loc.subtract(x + deltaX * d, 0.1D, z + deltaZ * d);
                            }
                        }
                    }
                    if (pe.getShape().equals("star3")) {
                        Location loc = p.getLocation();
                        for (int iteration = 0; iteration < 8; iteration++) {
                            double angle = 45.0D * iteration;
                            angle = Math.toRadians(angle);
                            double x = Math.cos(angle) * 2.7D;
                            double z = Math.sin(angle) * 2.7D;
                            double deltaX = 0.0D - x;
                            double deltaZ = 0.0D - z;
                            double distance = 1.0D;
                            for (double d = 0.0D; d < distance - 0.1D; d += 0.05D) {
                                loc.add(x + deltaX * d, 0.0D, z + deltaZ * d);
                                MathParticles.spawnParticle(p.getWorld(), pe, loc, rgb1, rgb2, rgb3, p);
                                loc.subtract(x + deltaX * d, 0.0D, z + deltaZ * d);
                            }
                        }
                    }
                    if (pe.getShape().equals("tornado"))
                        MathParticles.spawnTornado(p.getLocation(), pe, rgb1, rgb2, rgb3, p);
                }
        }
    }
}
