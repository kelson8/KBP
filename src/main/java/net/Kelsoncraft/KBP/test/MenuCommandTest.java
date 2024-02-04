package net.Kelsoncraft.KBP.test;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.ChatColorUtil;
import net.Kelsoncraft.KBP.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

// Inventories and items https://www.youtube.com/watch?v=WkWnq6DvWvI&list=PLfu_Bpi_zcDNEKmR82hnbv9UxQ16nUBF7&index=19
// Try and make this loop through a list to get a couple of items into a menu.

public class MenuCommandTest implements CommandExecutor {

    private final KbpMain plugin;
    private MenuCommandTest menu;

    public MenuCommandTest(KbpMain passedPlugin){
        this.plugin = passedPlugin;
    }

    private String format(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @NotNull String[] args) {

        if (sender instanceof Player){
            // Sizes for inventories
            // 9 18 27 36 45 54

            Player player = (Player) sender;
//            Inventory inventory = Bukkit.createInventory(player, 36, ChatColor.BLUE + "Test Menu");
            Inventory inventory = Bukkit.createInventory(player, 36, ChatColorUtil.format("&5&lTest Menu"));

            // Setting up the items
//            ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
//            ItemMeta itemMeta = item.getItemMeta();
//            itemMeta.setDisplayName(ChatColor.DARK_RED + "Click this");
//            item.setItemMeta(itemMeta);

            ItemStack steak = new ItemStack(Material.BEEF, 16);

            ItemStack flower = new ItemStack(Material.POPPY);
            ItemMeta flowerMeta = flower.getItemMeta();
            flowerMeta.setDisplayName("Knockback flowey");

            ArrayList<String> lore = new ArrayList<>();
            lore.add("This is the ");
            lore.add("coolest flower ");
            lore.add("on the planet");
            flowerMeta.setLore(lore);

            // Add enchants

            flowerMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
            flowerMeta.addEnchant(Enchantment.DAMAGE_ALL, 25, true);
            flower.setItemMeta(flowerMeta);



            // Clear the inventory
//            inventory.clear();
            // Adds item in first slot
//            inventory.addItem(item);

            inventory.addItem(steak);
            // Add the item in a specified slot
            inventory.setItem(2, flower);

            player.openInventory(inventory);

        } else {
            sender.sendMessage(Messages.KBP_errormsg() + "Console cannot use this command!");
        }

        return false;
    }
}
