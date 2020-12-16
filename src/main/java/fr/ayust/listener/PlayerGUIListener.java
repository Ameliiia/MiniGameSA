package main.java.fr.ayust.listener;

import main.java.fr.ayust.Main;
import main.java.fr.ayust.lobby.LobbyManager;
import main.java.fr.ayust.random.RandomEffect;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.util.Arrays;
import java.util.Random;

public class PlayerGUIListener implements Listener {

    //Random rand = new Random();

    @EventHandler
    public void OnClick(InventoryClickEvent e){

        final ItemStack is = e.getCurrentItem();
        final Player p = (Player) e.getWhoClicked();
        final Entity killer = p.getKiller();


        if(is.getType().equals(Material.SKELETON_SKULL) && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("Mini-GAME WIP")) {


            LobbyManager.inLobby(p);

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable(){
                @Override
                public void run() {

                    p.sendMessage("§3Votre partie va bientôt commencer :D");
                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                    p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                    p.removePotionEffect(PotionEffectType.WATER_BREATHING);
                    p.removePotionEffect(PotionEffectType.REGENERATION);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(new Location(Bukkit.getWorld("world"),22.115, 64, -245));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000,1, false, false, false));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,100000, 1, false, false, false));
                    p.getInventory().clear();
                    p.setHealth(20.0);
                    p.setFoodLevel(20);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100,1000, false, false, false ));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1000, false, false, false));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 100000, false, false, false));

                    RandomEffect.setRandomEffect(p);

                }
            }, 100L);

        }

        if(is == null || is.getType().equals(Material.AIR))
            return;

        final ItemMeta im = is.getItemMeta();

        assert  im != null;

        final InventoryView iv = e.getView();



        if(iv.getTitle().contains("§3Mode")) {
            e.setCancelled(true);
        }
    }


}
