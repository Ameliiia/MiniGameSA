package main.java.fr.ayust.lobby;

import main.java.fr.ayust.Main;
import main.java.fr.ayust.listener.AnnounceConnectionRunnable;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;



public class LobbyManager implements Listener {

    public static void inLobby(Player p) {

        p.teleport(new Location(Bukkit.getWorld("world"), 82, 121, -87 )); // TODO: Arena Manager or Lobby Manager
        p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().clear();
        p.setHealth(20.0);
        p.setFoodLevel(20);

        new AnnounceConnectionRunnable(p).runTaskTimer(Main.getInstance(), 0L, 20L);

    }
}
