package main.java.fr.ayust.command;

import main.java.fr.ayust.gui.PlayerGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandDeath implements CommandExecutor {

    private static CommandDeath INSTANCE;
    private static List<In> jeu_en_cours;

    private CommandDeath() {
        jeu_en_cours = new ArrayList<>();
    }

    public static CommandDeath getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommandDeath();
        }
        return INSTANCE;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if(!(sender instanceof Player))
        return false;

        final Player p = ((Player) sender).getPlayer();

        if(label.equalsIgnoreCase("death") && sender instanceof  Player) {


            new PlayerGUI().open(p);


            if(inGame(p))
            return true;



        }



        return false;
    }

    public static boolean inGame(Player p) {
        return jeu_en_cours.contains(p);

    }

    public static List<In> getGame_en_cours () {
        return jeu_en_cours;
    }
}
