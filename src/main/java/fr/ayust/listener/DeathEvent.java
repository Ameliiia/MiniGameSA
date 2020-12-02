package main.java.fr.ayust.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class DeathEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player p = event.getEntity();


        p.sendMessage("Hello");
        p.setGameMode(GameMode.CREATIVE);


    }
}
