package main.java.fr.ayust.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class RandomEffect implements Listener {
    Random rand = new Random();

    @EventHandler
    public void onPlayerJoinLobby(PlayerJoinEvent e){
        final Player p = e.getPlayer();
    }
}
