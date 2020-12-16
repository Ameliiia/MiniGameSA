package main.java.fr.ayust.dead;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class deadByZombie implements Listener {

    @EventHandler
    public void onZombieKill(EntityDamageByEntityEvent event) {
        Player p = (Player) event.getEntity();
        Damageable dmg = p;

        if (event.getEntity() instanceof Player) {


            if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.ZOMBIE) {
                if (dmg.getHealth() - event.getDamage() <= 0D) {
                    p.setGameMode(GameMode.SPECTATOR);
                }
            } else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.ZOMBIE_VILLAGER) {
                if (dmg.getHealth() - event.getDamage() <= 0D) {
                    p.setGameMode(GameMode.SPECTATOR);
                }
            } else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.ZOMBIFIED_PIGLIN) {
                if (dmg.getHealth() - event.getDamage() <= 0D) {
                    p.setGameMode(GameMode.SPECTATOR);
                }
            } else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.CREEPER) {
                if (dmg.getHealth() - event.getDamage() <= 0D) {
                    p.setBedSpawnLocation(new Location(Bukkit.getWorld("world"), 22.115, 64, -245), true);
                    p.spigot().respawn();

                }
            }
        }
    }
}
