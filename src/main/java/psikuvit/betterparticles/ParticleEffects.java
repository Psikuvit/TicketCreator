package psikuvit.betterparticles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import psikuvit.betterparticles.Utils.XParticle;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

@SerializableAs("Particle")
public class ParticleEffects implements ConfigurationSerializable {
    private String name = null;

    private List<String> lore = null;

    private Material type = null;

    private String id = null;

    private String shape = null;

    private XParticle pa = null;

    private int amount;

    private String inv = null;

    private Color color = null;

    private String permission = null;

    public ParticleEffects(String name, List<String> lore, Material type, String id, String shape, XParticle pa, Integer amount, String inv, Color color, String permission) {
        this.name = name;
        this.lore = lore;
        this.type = type;
        this.id = id;
        this.shape = shape;
        this.pa = pa;
        this.amount = amount.intValue();
        this.inv = inv;
        this.color = color;
        this.permission = permission;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getLore() {
        return this.lore;
    }

    public Material getItem() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public String getShape() {
        return this.shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public XParticle getParticle() {
        return this.pa;
    }

    public void setParticle(XParticle flame) {
        this.pa = flame;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getinv() {
        return this.inv;
    }

    public void setinv(String inv) {
        this.inv = inv;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("lore", this.lore);
        map.put("material", this.type.toString());
        map.put("id", this.id);
        map.put("shape", this.shape);
        String name = null;
        if (this.pa != null)
            name = this.pa.name();
        map.put("particle", name);
        map.put("amount", Integer.valueOf(this.amount));
        map.put("inv", this.inv);
        map.put("color", this.color);
        map.put("permission", this.permission);
        return map;
    }

    public static ParticleEffects deserialize(Map<String, Object> args) {
        String name = (String)args.get("name");
        List<String> lore = (List<String>)args.get("lore");
        Material type = Material.getMaterial((String)args.get("material"));
        String id = (String)args.get("id");
        String shape = (String)args.get("shape");
        XParticle pa = XParticle.FLAME;
        byte b;
        int i;
        XParticle[] arrayOfXParticle;
        for (i = (arrayOfXParticle = XParticle.values()).length, b = 0; b < i; ) {
            XParticle xp = arrayOfXParticle[b];
            if (xp.name().equals(args.get("particle")))
                pa = XParticle.valueOf((String)args.get("particle"));
            b = (byte)(b + 1);
        }
        int amount = ((Integer)args.get("amount")).intValue();
        String inv = (String)args.get("inv");
        Color color = (Color)args.get("color");
        String permission = null;
        if ((String)args.get("permission") != null)
            permission = (String)args.get("permission");
        return new ParticleEffects(name, lore, type, id, shape, pa, Integer.valueOf(amount), inv, color, permission);
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
