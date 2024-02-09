package net.Kelsoncraft.KBP.test;

import com.google.common.collect.Multimap;
import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.Messages;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static net.Kelsoncraft.KBP.util.ChatColorUtil.format;

public class LoreTest implements CommandExecutor {

    private final KbpMain plugin;

    public LoreTest(KbpMain passedPlugin){
        this.plugin = passedPlugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @NotNull String[] args) {

        if (sender instanceof Player) {
            // Todo Setup to where player can fly while holding this flower.
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("flower")) {
                ArrayList<String> specialFlowerLore = new ArrayList<>();
                specialFlowerLore.add(format("&bSpecial"));
                specialFlowerLore.add(format("&Flower"));

                ItemStack specialFlower = new ItemStack(Material.POPPY);
                ItemMeta specialFlowerMeta = specialFlower.getItemMeta();
                specialFlowerMeta.setDisplayName("&b&lSpecial Flower");
                specialFlowerMeta.setLore(specialFlowerLore);


                player.getInventory().addItem(specialFlower);
                player.sendMessage(Messages.KBP_Main() + "You have been given the special flower!");

            }
        } else {
            sender.sendMessage(Messages.ConsoleCommandError());
        }

        return false;
    }
}
