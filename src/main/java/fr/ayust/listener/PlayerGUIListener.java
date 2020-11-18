package main.java.fr.ayust.listener;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class PlayerGUIListener implements Listener {

    @EventHandler
    public void OnClick(InventoryClickEvent e){

        final ItemStack is = e.getCurrentItem();
        final Player p = (Player) e.getWhoClicked();

        if(is.getType().equals(Material.SKELETON_SKULL) && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("Mini-GAME WIP")) {
            p.teleport(new Location(Bukkit.getWorld("world"), 22, 64, -245 )); // TODO: Arena Manager or Lobby Manager
            p.setGameMode(GameMode.SURVIVAL);
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1000));
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1000000,1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1000000, 1000));
            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 1000));
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
