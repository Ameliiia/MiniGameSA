package main.java.fr.ayust.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PlayerGUI {

    public void open(Player p){

        final Inventory inv = Bukkit.createInventory(p, 54, "§3Mode de jeu");

        final ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);

        final ItemStack death = new ItemStack(Material.SKELETON_SKULL);
        final ItemMeta deathItem = death.getItemMeta();
        assert deathItem != null;
        deathItem.setDisplayName("Mini-GAME WIP");
        deathItem.setLore(Arrays.asList("§6Meurs le plus vite :D"));
        death.setItemMeta(deathItem);

        final ItemStack rule= new ItemStack(Material.WRITTEN_BOOK);
        final BookMeta ruleBook = (BookMeta) rule.getItemMeta();
        ruleBook.setTitle("§dRègle du jeu");
        ruleBook.setAuthor("§aAyust §r, §6Bershall §r, §cDraskeer §r, §1Girdot");
        ruleBook.setLore(Arrays.asList("§eCeci sont les régles du jeu! ehe te nandayo"));
        ruleBook.setDisplayName("§dRègle du jeu");
        ruleBook.setPages("§2Salut à toi :D.§r\nEs-tu malchanceux ou chanceux.\n\n1", "Test");
        rule.setItemMeta(ruleBook);


        for (int i = 0; i < 9; i++) {
            inv.setItem(i, glass);
        }

        inv.setItem(8, glass);
        inv.setItem(17, glass);
        inv.setItem(26, glass);
        inv.setItem(35, glass);

        inv.setItem(22, death);
        inv.setItem(31, rule);

        inv.setItem(9, glass);
        inv.setItem(18, glass);
        inv.setItem(27, glass);
        inv.setItem(36, glass);

        for (int i = 44; i < 54; i++) {
            inv.setItem(i, glass);
        }

        p.openInventory(inv);



    }
}
