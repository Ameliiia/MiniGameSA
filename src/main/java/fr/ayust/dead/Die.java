package main.java.fr.ayust.dead;


import main.java.fr.ayust.command.CommandDeath;
import main.java.fr.ayust.command.In;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class Die implements Listener {

    private Player winner;

    private In in;


    @EventHandler
    public void PlayerRespawn(PlayerDeathEvent event) {
            this.winner = event.getEntity();
            if (CommandDeath.inGame(winner)) {
                for(In in : CommandDeath.getGame_en_cours()) {
                    if (in.contains(winner)) {
                        this.in = in;
                        break;
                    }
                }
            }

            if (this.in.getP().equals(winner)) {
                this.winner = this.in.getP();
            }

            winner.sendMessage("Tu viens de te qualifier");

            this.in.getP().getInventory().clear();

            winner.spigot().respawn();
            this.in.getP().teleport(new Location(Bukkit.getWorld("world"), 82, 121, -87 ));
            winner.setGameMode(GameMode.SPECTATOR);


            CommandDeath.getGame_en_cours().remove(this.in);

    }
}
