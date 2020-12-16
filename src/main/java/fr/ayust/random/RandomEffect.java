package main.java.fr.ayust.random;

import main.java.fr.ayust.dead.Die;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class RandomEffect implements Listener {


    public static void setRandomEffect (Player p) {



        Random rand = new Random();

        final ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        final ItemMeta bootsItem = boots.getItemMeta();
        assert bootsItem != null;
        bootsItem.addEnchant(Enchantment.PROTECTION_FALL, 1000, true);
        bootsItem.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        boots.setItemMeta(bootsItem);

        int chance = rand.nextInt(5);


        if(chance == 0)
        {
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000,1, false, false, false));


        }
        else if (chance == 1)
        {

            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,100000, 100, false, false, false ));
        }
        else if (chance == 2)
        {
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,100000,10, false, false, false ));
        }
        else if (chance == 3)
        {
            p.getInventory().setBoots(boots);
        }
        else if (chance == 4)
        {

        }
        else
        {
            return;
        }

    }
}
