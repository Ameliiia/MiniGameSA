package main.java.fr.ayust.listener;

import main.java.fr.ayust.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.util.Random;

public class PlayerGUIListener implements Listener {

    Random rand = new Random();

    @EventHandler
    public void OnClick(InventoryClickEvent e){

        final ItemStack is = e.getCurrentItem();
        final Player p = (Player) e.getWhoClicked();


        if(is.getType().equals(Material.SKELETON_SKULL) && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("Mini-GAME WIP")) {
            p.teleport(new Location(Bukkit.getWorld("world"), 82, 121, -87 )); // TODO: Arena Manager or Lobby Manager
            p.setGameMode(GameMode.ADVENTURE);
            p.getInventory().clear();

            p.setHealth(20.0);
            p.setFoodLevel(20);

            new AnnounceConnectionRunnable(p).runTaskTimer(Main.getInstance(), 0L, 20L);

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable(){
                @Override
                public void run() {

                    final ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                    final ItemMeta bootsItem = boots.getItemMeta();
                    assert bootsItem != null;
                    bootsItem.addEnchant(Enchantment.PROTECTION_FALL, 1000, true);
                    bootsItem.addEnchant(Enchantment.BINDING_CURSE, 1, true);
                    boots.setItemMeta(bootsItem);

                    p.sendMessage("§3Votre partie va bientôt commencer :D");
                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
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

                    int chance = rand.nextInt(4);

                    if(chance == 0)
                    {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000,1, false, false, false));
                        p.getInventory().setBoots(boots);

                    }
                    else if (chance == 1)
                    {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,100000, 100, false, false, false ));
                        p.getInventory().setBoots(boots);

                    }
                    else if (chance == 2)
                    {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,100000,100, false, false, false ));
                        p.getInventory().setBoots(boots);
                    }
                    else if (chance == 3)
                    {
                        p.getInventory().setBoots(boots);
                    } else
                    {
                        return;
                    }
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
