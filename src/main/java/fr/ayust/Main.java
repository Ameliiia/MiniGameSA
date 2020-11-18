package main.java.fr.ayust;

import main.java.fr.ayust.command.CommandDeath;
import main.java.fr.ayust.listener.PlayerGUIListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerGUIListener(), this);

        getCommand("death").setExecutor(new CommandDeath());

        super.onEnable();

        getLogger().info("[MiniGameSA] has been enable");

    }

    @Override
    public void onDisable(){

        super.onDisable();

        getLogger().info("[MiniGameSA] has been disable");

    }

}
