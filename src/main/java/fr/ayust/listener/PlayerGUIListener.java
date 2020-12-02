package main.java.fr.ayust.listener;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PlayerGUIListener implements Listener {




    Random rand = new Random();
    @EventHandler
    public void OnClick(InventoryClickEvent e){

        //List<PotionEffectType> effectTypes = new ArrayList<>();
        //effectTypes.add(PotionEffectType.FIRE_RESISTANCE);
        //effectTypes.add(PotionEffectType.REGENERATION);
        //effectTypes.add(PotionEffectType.SATURATION);
        //effectTypes.add(PotionEffectType.WATER_BREATHING);


        final ItemStack is = e.getCurrentItem();
        final Player p = (Player) e.getWhoClicked();

        if(is.getType().equals(Material.SKELETON_SKULL) && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("Mini-GAME WIP")) {
            p.teleport(new Location(Bukkit.getWorld("world"), 82, 121, -87 )); // TODO: Arena Manager or Lobby Manager
            p.setGameMode(GameMode.SURVIVAL);
            p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000,1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,100000, 1));
            p.getInventory().clear();

            p.setHealth(20.0);
            p.setFoodLevel(20);



            int chance = rand.nextInt(3);
            if(chance == 0)
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000,1));
            }
            else if (chance == 1)
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,100000, 100));
            }
            else if (chance == 2)
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,100000,100));
            } else
            {
                return;
            }


            //Random rand = new Random();
            //PotionEffectType effect = effectTypes.get(rand.nextInt(effectTypes.size()));

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
