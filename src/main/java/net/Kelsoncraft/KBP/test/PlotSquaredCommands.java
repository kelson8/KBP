package net.Kelsoncraft.KBP.test;

import com.google.common.eventbus.Subscribe;
import com.plotsquared.core.PlotAPI;
import com.plotsquared.core.configuration.caption.TranslatableCaption;
import com.plotsquared.core.events.PlayerEnterPlotEvent;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.Plot;
import net.Kelsoncraft.KBP.KbpMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class PlotSquaredCommands implements CommandExecutor {

    private final KbpMain plugin;

    public PlotSquaredCommands(KbpMain passedPlugin){
        this.plugin = passedPlugin;
    }

    public PlotSquaredCommands(KbpMain plugin, PlotAPI api){
        this.plugin = plugin;
        api.registerListener(this);
    }

    @Subscribe
    public void onPlayerEnterPlot(PlayerEnterPlotEvent e){
        Plot plot = e.getPlot();
        PlotPlayer<?> plotPlayer = e.getPlotPlayer();

        // https://github.com/IntellectualSites/PlotSquared/blob/main/Core/src/main/java/com/plotsquared/core/player/PlotPlayer.java#L730
        // Where would I get this key value?
        plotPlayer.sendMessage(TranslatableCaption.of(""));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, @NotNull String[] args){

        return false;
    }

}
