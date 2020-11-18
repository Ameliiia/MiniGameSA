package main.java.fr.ayust;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){

        getLogger().info("[MiniGameSA] has been enable");

    }

    @Override
    public void onDisable(){

        getLogger().info("[MiniGameSA] has been disable");

    }

}
