package net.Kelsoncraft.KBP.listeners;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.ChatColorUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    private final KbpMain plugin;

    public MenuListener(KbpMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        // Check if the name is the Test Menu and send messages.
        if(e.getView().getTitle().equalsIgnoreCase(ChatColorUtil.format("&5&lTest Menu"))){

            if(e.getCurrentItem() == null){
                return;
            }

//            if(e.getCurrentItem().getType() == Material.POPPY) {
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Knockback flowey")) {
                System.out.println("You clicked the poppy");
            } else if(e.getCurrentItem().getType() == Material.BEEF) {
                System.out.println("You clicked on the steak");
            } else {
                System.out.println("You clicked on something else.");
            }
            // Disabled moving the custom menu items
            e.setCancelled(true);
        }
    }
}
