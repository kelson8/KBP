package net.Kelsoncraft.KBP.listeners;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.ChatColorUtil;
import net.Kelsoncraft.KBP.util.Messages;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

// https://www.spigotmc.org/threads/sending-a-message-on-inventoryclickevent.202344/

public class MenuListener implements Listener {

    private final KbpMain plugin;
    // Economy support
    private static Economy econ;

    // Cooldowns: https://www.youtube.com/watch?v=3QQPNfcbeyk&list=PLfu_Bpi_zcDNEKmR82hnbv9UxQ16nUBF7&index=19
    // Key = UUID of the player
    // Longer = The epoch time of when they ran the command.
    private final HashMap<UUID, Long> cooldown;
    public MenuListener(KbpMain plugin) {
        this.plugin = plugin;
        this.cooldown = new HashMap<>();
    }

    // Todo Make this show a message on the screen instead of in the chat whenever it is pressed.
    // https://www.spigotmc.org/threads/how-can-i-display-a-message-that-pops-up-on-the-screen.561460/
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        // This below was needed for the money to be given, But it does work now.
        econ = KbpMain.getEconomy();

        // I figured out how to get the player in this event.
        Player player = (Player) e.getWhoClicked();

        // Check if the name is the Test Menu and send messages.
        if (e.getView().getTitle().equalsIgnoreCase(ChatColorUtil.format("&5&lTest Menu"))) {
            if (e.getCurrentItem() == null) {
                return;
            }

            // Try to check if this is in the menu, it also fires off if it's in the player inventory too and could be exploited.
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Knockback flowey")) {

                // https://www.geeksforgeeks.org/java-program-to-convert-milliseconds-to-minutes-and-seconds/
                long currentMs = System.currentTimeMillis();
                long seconds = TimeUnit.MILLISECONDS.toSeconds(currentMs);

                // This works well, but when the user has the bypass permission they still get the cooldown.
                // Todo Fix this to where it doesn't reset the players money, Set this to get the value from the config.
                if (!this.cooldown.containsKey(player.getUniqueId()) || seconds - cooldown.get(player.getUniqueId()) > 5) {
                    if (player.hasPermission("kelson.menu.cooldown")) {
                        EconomyResponse r = econ.depositPlayer(player, 100.5);
                        player.sendMessage(String.format(Messages.KBP_Main() + "You have been given %s! You now have %s", econ.format(r.amount), econ.format(r.balance)));

                        // Looks like this fixes the bypass permission.
                    } else {
                        EconomyResponse r = econ.depositPlayer(player, 100.5);
                        player.sendMessage(String.format(Messages.KBP_Main() + "You have been given %s! You now have %s", econ.format(r.amount), econ.format(r.balance)));
                        this.cooldown.put(player.getUniqueId(), seconds);
                    }
                } else {
                    player.sendMessage(Messages.KBP_errormsg() + "You have to wait " + (5 - (seconds - cooldown.get(player.getUniqueId())) + " seconds"));
                    // Disables moving the custom menu items.
                    e.setCancelled(true);
                }
            } else if (e.getCurrentItem().getType() == Material.BEEF) {
                player.sendMessage(Messages.KBP_Main() + ChatColorUtil.format("&bYou clicked the &a&lsteak"));
            } else {
                System.out.println("You clicked on something else.");
            }
            //player.sendMessage(Messages.KBP_Main() + ChatColorUtil.format("&bYou clicked the &a&lpoppy"));

            // This shows up but behind the menu, I wonder how to fix that.
//                player.sendTitle("You clicked the poppy", "", 10, 70, 20);

            // Disabled moving the custom menu items
            e.setCancelled(true);
        }
    }
}
