package main.java.fr.ayust.getkill;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class KillByZombie implements Listener {

    @EventHandler
    public static void zombieDeath(EntityDamageByEntityEvent event) {
        Player p = (Player) event.getEntity();
        Damageable dmg = p;
        if ( event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.ZOMBIE) {

            if (dmg.getHealth() - event.getDamage() <= 0D) {
                p.setGameMode(GameMode.CREATIVE);

            }
        } else if ( event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.ZOMBIE_VILLAGER) {

            if (dmg.getHealth() - event.getDamage() <= 0D) {
                p.setGameMode(GameMode.CREATIVE);

            }
        }
        else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.SKELETON) {

            if (dmg.getHealth() - event.getDamage() <= 0D) {
                p.teleport(new Location(Bukkit.getWorld("world"), 22.115, 64, -245));
                p.sendMessage("Tu n'es pas mort de la bonne manière");
            }
        } else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.BLAZE) {


            if (dmg.getHealth() - event.getDamage() <= 0D) {
                p.teleport(new Location(Bukkit.getWorld("world"), 22.115, 64, -245));
                p.sendMessage("Tu n'es pas mort de la bonne manière");
            }
        } else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.CREEPER) {


            if (dmg.getHealth() - event.getDamage() <= 0D) {
                p.teleport(new Location(Bukkit.getWorld("world"), 22.115, 64, -245));
                p.sendMessage("Tu n'es pas mort de la bonne manière");
            }
        } else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.POLAR_BEAR) {


            if (dmg.getHealth() - event.getDamage() <= 0D) {
                p.teleport(new Location(Bukkit.getWorld("world"), 22.115, 64, -245));
                p.sendMessage("Tu n'es pas mort de la bonne manière");
            }
        } else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.ENDER_DRAGON) {


            if (dmg.getHealth() - event.getDamage() <= 0D) {
                p.teleport(new Location(Bukkit.getWorld("world"), 22.115, 64, -245));
                p.sendMessage("Tu n'es pas mort de la bonne manière");
            }
        } else if (event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.ENDER_PEARL) {


            if (dmg.getHealth() - event.getDamage() <= 0D) {
                p.teleport(new Location(Bukkit.getWorld("world"), 22.115, 64, -245));
                p.sendMessage("Tu n'es pas mort de la bonne manière");
            }
        }
    }
}
