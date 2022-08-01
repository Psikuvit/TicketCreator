package psikuvit.betterparticles.Runnables;

import psikuvit.betterparticles.Main;
import psikuvit.betterparticles.ParticleEffects;
import psikuvit.betterparticles.Utils.MathParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Wing extends BukkitRunnable {
    static boolean x = true;

    static boolean o = false;

    private static boolean[][] shape1 = new boolean[][] {
            {
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, x, o, o,
            o, o, o, o, o, o, x, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, x, x, o, o,
            o, o, o, o, o, o, x, x, o, o,
            o, o, o, o }, {
            o, o, o, o, o, x, x, x, x, o,
            o, o, o, o, o, x, x, x, x, o,
            o, o, o, o }, {
            o, o, o, o, o, x, x, x, x, o,
            o, o, o, o, o, x, x, x, x, o,
            o, o, o, o }, {
            o, o, o, o, o, o, x, x, x, x,
            o, o, o, o, x, x, x, x, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, x, x, x,
            x, o, o, x, x, x, x, o, o, o,
            o, o, o, o },
            {
                    o, o, o, o, o, o, o, o, x, x,
                    x, x, x, x, x, x, o, o, o, o,
                    o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, x,
            x, x, x, x, x, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            x, x, x, x, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, x,
            x, o, o, x, x, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, x, x,
            x, o, o, x, x, x, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, x, x,
            o, o, o, o, x, x, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, x, o,
            o, o, o, o, o, x, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o } };

    private static boolean[][] shape2 = new boolean[][] {
            {
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, x, x, x, x, x, x, o,
            o, o, o, o, o, x, x, x, x, x,
            x, o, o, o }, {
            o, o, o, o, o, x, x, x, x, x,
            o, o, o, o, x, x, x, x, x, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, x, x, x,
            x, o, o, x, x, x, x, o, o, o,
            o, o, o, o },
            {
                    o, o, o, o, o, o, o, o, o, x,
                    x, x, x, x, x, o, o, o, o, o,
                    o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            x, x, x, x, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, x, x, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o } };

    private static boolean[][] shape3 = new boolean[][] {
            {
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, x, x, x,
            o, o, o, o, x, x, x, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, x, x, x, x, x,
            o, o, o, o, x, x, x, x, x, o,
            o, o, o, o }, {
            o, o, o, o, o, x, x, x, x, x,
            x, o, o, x, x, x, x, x, x, o,
            o, o, o, o },
            {
                    o, o, o, o, o, x, x, x, x, x,
                    x, x, x, x, x, x, x, x, x, x,
                    o, o, o, o }, {
            o, o, o, o, x, x, x, x, x, x,
            x, x, x, x, x, x, x, x, x, x,
            o, o, o, o }, {
            o, o, o, o, x, x, x, x, x, x,
            x, x, x, x, x, x, x, x, x, x,
            o, o, o, o }, {
            o, o, o, o, x, x, x, x, o, o,
            o, o, o, o, o, o, x, x, x, x,
            x, o, o, o }, {
            o, o, o, x, x, x, x, x, o, o,
            o, o, o, o, o, o, x, x, x, x,
            x, o, o, o }, {
            o, o, o, x, x, x, x, o, o, o,
            o, o, o, o, o, o, o, x, x, x,
            x, o, o, o }, {
            o, o, x, x, x, x, x, o, o, o,
            o, o, o, o, o, o, o, x, x, x,
            x, x, o, o }, {
            o, o, o, x, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            x, o, o, o } };

    private static boolean[][] shape4 = new boolean[][] {
            {
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, x, x, x, x, x,
            o, o, o, o, x, x, x, x, x, o,
            o, o, o, o }, {
            o, o, o, x, x, x, x, o, o, o,
            o, o, o, o, o, o, o, x, x, x,
            x, o, o, o }, {
            o, o, x, x, x, x, x, o, o, o,
            o, o, o, o, o, o, o, x, x, x,
            x, x, o, o }, {
            o, x, x, x, x, x, x, x, o, o,
            o, o, o, o, o, o, x, x, x, x,
            x, x, x, o }, {
            o, x, x, x, x, x, x, x, x, x,
            o, o, o, o, x, x, x, x, x, x,
            x, x, o, o }, {
            x, x, x, x, x, x, x, x, x, x,
            x, o, o, x, x, x, x, x, o, x,
            x, x, x, x },
            {
                    x, o, x, o, x, x, x, x, x, x,
                    x, x, x, x, x, x, x, x, x, x,
                    o, x, o, x }, {
            x, x, x, o, x, x, x, x, x, x,
            x, o, o, x, x, x, o, x, x, x,
            o, x, x, x }, {
            x, x, o, x, o, x, o, x, o, o,
            o, o, o, o, o, x, x, o, x, o,
            x, o, x, x }, {
            x, x, o, x, o, x, x, o, o, o,
            o, o, o, o, o, o, o, x, x, o,
            x, o, x, x }, {
            x, x, o, x, x, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, x,
            x, o, x, x }, {
            o, x, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, x, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, x, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o } };

    private static boolean[][] shape5 = new boolean[][] {
            {
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o, o, o, o, o, o, o,
                    o, o, o, o }, {
            o, o, o, x, x, x, x, o, o, o,
            o, o, o, o, o, o, o, x, x, x,
            x, o, o, o }, {
            o, o, x, x, x, x, x, x, o, o,
            o, o, o, o, o, o, x, x, x, x,
            x, x, o, o }, {
            o, o, x, x, x, x, x, x, x, o,
            o, o, o, o, o, x, x, x, x, x,
            x, x, o, o }, {
            o, o, x, x, x, o, x, x, x, o,
            o, o, o, o, o, x, x, x, o, x,
            x, x, o, o }, {
            o, o, x, x, o, x, o, x, x, x,
            o, o, o, o, x, x, x, o, x, o,
            x, x, o, o }, {
            o, o, x, x, x, o, x, o, x, x,
            o, o, o, o, x, x, o, x, o, x,
            x, x, o, o }, {
            o, o, x, x, x, x, o, x, o, x,
            x, o, o, x, x, o, x, o, x, x,
            x, x, o, o }, {
            o, o, o, x, x, x, x, o, x, x,
            x, o, o, x, x, x, o, x, x, x,
            x, o, o, o }, {
            o, o, o, x, x, x, x, o, x, x,
            x, x, x, x, x, x, o, x, x, x,
            x, o, o, o },
            {
                    o, o, o, o, x, x, x, o, o, x,
                    x, x, x, x, x, o, o, x, x, x,
                    o, o, o, o }, {
            o, o, o, o, x, x, x, x, x, x,
            x, x, x, x, x, x, x, x, x, x,
            o, o, o, o }, {
            o, o, o, o, o, x, x, o, o, x,
            x, o, o, x, x, o, o, o, x, o,
            o, o, o, o }, {
            o, o, o, o, o, o, x, x, x, o,
            o, o, o, o, o, x, x, x, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o }, {
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o, o, o, o, o, o, o,
            o, o, o, o } };

    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (Main.getParticleEffectItem(p) != null && Main.getParticleEffectItem(p).size() != 0)
                for (ParticleEffects pe : Main.getParticleEffectItem(p)) {
                    if (pe.getShape().equals("wings1"))
                        drawWings(p.getLocation(), pe, p, shape1);
                    if (pe.getShape().equals("wings2"))
                        drawWings(p.getLocation(), pe, p, shape2);
                    if (pe.getShape().equals("wings3"))
                        drawWings(p.getLocation(), pe, p, shape3);
                    if (pe.getShape().equals("wings4"))
                        drawWings(p.getLocation(), pe, p, shape4);
                    if (pe.getShape().equals("wings5"))
                        drawWings(p.getLocation(), pe, p, shape5);
                }
        }
    }

    private void drawWings(Location location, ParticleEffects pe, Player p, boolean[][] shape) {
        float rgb1 = MathParticles.getRGB(1, pe);
        float rgb2 = MathParticles.getRGB(2, pe);
        float rgb3 = MathParticles.getRGB(3, pe);
        double space = 0.2D;
        double defX = location.getX() - 2.2D;
        double x = defX;
        double y = location.clone().getY() + 3.2D;
        double z = location.clone().getZ();
        double fire = -((location.getYaw() + 180.0F) / 60.0F);
        fire += (location.getYaw() < -180.0F) ? 3.25D : 2.985D;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < (shape[i]).length; j++) {
                if (shape[i][j]) {
                    Location target = location.clone();
                    target.setX(x);
                    target.setY(y);
                    target.setZ(z);
                    Vector v = target.toVector().subtract(location.toVector());
                    Vector v2 = getBackVector(location);
                    v = rotateAroundAxisY(v, fire);
                    v2.setY(0).multiply(-0.5D);
                    location.add(v);
                    location.add(v2);
                    for (int k = 0; k < 3; k++)
                        MathParticles.spawnParticle(location.getWorld(), pe, location, rgb1, rgb2, rgb3, p);
                    location.subtract(v2);
                    location.subtract(v);
                }
                x += space;
            }
            y -= space;
            z += 0.01D;
            x = defX;
        }
    }

    public static Vector rotateAroundAxisY(Vector v, double fire) {
        double cos = Math.cos(fire);
        double sin = Math.sin(fire);
        double x = v.getX() * cos + v.getZ() * sin;
        double z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }

    public static Vector getBackVector(Location loc) {
        float newZ = (float)(loc.getZ() + 1.0D * Math.sin(Math.toRadians((loc.getYaw() + 90.0F))));
        float newX = (float)(loc.getX() + 1.0D * Math.cos(Math.toRadians((loc.getYaw() + 90.0F))));
        return new Vector(newX - loc.getX(), 0.0D, newZ - loc.getZ());
    }
}
