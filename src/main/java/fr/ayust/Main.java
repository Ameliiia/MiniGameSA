package main.java.fr.ayust;

import main.java.fr.ayust.command.CommandDeath;

import main.java.fr.ayust.dead.Die;
import main.java.fr.ayust.dead.deadByZombie;
import main.java.fr.ayust.listener.PlayerGUIListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

private static Main instance;
    public static Plugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable(){

        PluginManager pm = Bukkit.getPluginManager();

        Die listener = new Die();


        pm.registerEvents(new PlayerGUIListener(), this);
        pm.registerEvents(new deadByZombie(), this);
        pm.registerEvents(new Die(), this);
        instance = this;


        getCommand("death").setExecutor(CommandDeath.getInstance());

        super.onEnable();

        getLogger().info("[MiniGameSA] has been enable");


    }

    @Override
    public void onDisable(){

        super.onDisable();

        getLogger().info("[MiniGameSA] has been disable");

    }

}
