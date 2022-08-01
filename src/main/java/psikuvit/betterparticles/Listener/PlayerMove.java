package psikuvit.betterparticles.Listener;

import psikuvit.betterparticles.Main;
import psikuvit.betterparticles.ParticleEffects;
import psikuvit.betterparticles.Utils.MathParticles;
import psikuvit.betterparticles.Utils.XParticle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;

public class PlayerMove implements Listener {
    public HashMap<Player, Float> auracount = new HashMap<>();

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (Main.getParticleEffectItem(p) != null && Main.getParticleEffectItem(p).size() != 0)
            for (ParticleEffects pe : Main.getParticleEffectItem(p)) {
                if (pe.getParticle() == null ||
                        pe.getShape() == null)
                    continue;
                float rgb1 = MathParticles.getRGB(1, pe);
                float rgb2 = MathParticles.getRGB(2, pe);
                float rgb3 = MathParticles.getRGB(3, pe);
                int amounttrail = 3;
                if (pe.getParticle() == XParticle.EXPLOSION_LARGE || pe.getParticle() == XParticle.LAVA)
                    amounttrail = 1;
                int amounthat = 8;
                if (pe.getParticle() == XParticle.EXPLOSION_LARGE || pe.getParticle() == XParticle.LAVA)
                    amounthat = 1;
                if (pe.getAmount() != 0) {
                    amounttrail = pe.getAmount();
                    amounthat = pe.getAmount();
                }
                if (pe.getShape().equals("trail"))
                    for (int i = 0; i < amounttrail; i++)
                        MathParticles.spawnParticle(p.getWorld(), pe, p.getLocation().add(0.0D, 0.5D, 0.0D), rgb1, rgb2, rgb3, p);
                if (pe.getShape().equals("hat"))
                    for (int i = 0; i < amounthat; i++)
                        MathParticles.spawnParticle(p.getWorld(), pe, p.getLocation().add(0.0D, 2.4D, 0.0D), rgb1, rgb2, rgb3, p);
            }
    }
}
