package main.java.fr.ayust.command;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.PlayerInventory;

public class In implements Listener {

    private Player p;
    private PlayerInventory inv_p;
    private Location loc;


    public In(Player p) {
        this.p = p;
        this.inv_p = p.getInventory();
        this.loc = p.getLocation();
    }

    public boolean contains(Player p) {
        return (this.p.equals(p));
    }

    public Player getP() {
        return p;
    }

    public PlayerInventory getInv_p() {
        return inv_p;

    }
    public Location getLoc() {
        return loc;
    }
}
