package main.java.fr.ayust.command;

import main.java.fr.ayust.gui.PlayerGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDeath implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if(!(sender instanceof Player))
        return false;

        final Player p = ((Player) sender).getPlayer();

        if(label.equals("death")) {

            new PlayerGUI().open(p);
            return true;

        }



        return false;
    }
}
