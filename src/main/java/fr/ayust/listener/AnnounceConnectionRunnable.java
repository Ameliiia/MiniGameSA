package main.java.fr.ayust.listener;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AnnounceConnectionRunnable extends BukkitRunnable {


    public int time = 11;
    public Player p;


    public AnnounceConnectionRunnable(Player p) {
        this.p = p;
    }
    @Override
    public void run(){
        time--;

        if(time == 0) {
            this.cancel();
            return;
        }

        p.sendMessage("§eVotre partie va commencer dans: §9" + time);

    }

}
