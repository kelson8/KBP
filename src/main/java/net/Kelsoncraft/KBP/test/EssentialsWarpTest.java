package net.Kelsoncraft.KBP.test;

import com.earth2me.essentials.IUser;
import com.earth2me.essentials.commands.WarpNotFoundException;
import net.Kelsoncraft.KBP.KbpMain;
import net.ess3.api.IWarps;
import net.ess3.api.InvalidNameException;
import net.ess3.api.InvalidWorldException;
import org.bukkit.Location;

import java.io.File;
import java.util.Collection;
import java.util.UUID;

// I never did figure out how exactly to use this, I would like to add this into a menu, like /warpmenu to show a list of all the warps.

public class EssentialsWarpTest implements IWarps {

    private KbpMain plugin;
    public EssentialsWarpTest(KbpMain passedPlugin){
        this.plugin = passedPlugin;
    }

    @Override
    public Location getWarp(String warp) throws WarpNotFoundException, InvalidWorldException {
        return null;
    }

    @Override
    public Collection<String> getList() {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void removeWarp(String name) throws Exception {

    }

    @Override
    public void setWarp(String name, Location loc) throws Exception {

    }

    @Override
    public void setWarp(IUser user, String name, Location loc) throws Exception {

    }

    @Override
    public UUID getLastOwner(String warp) throws WarpNotFoundException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public File getWarpFile(String name) throws InvalidNameException {
        return null;
    }

    @Override
    public void reloadConfig() {

    }
}
