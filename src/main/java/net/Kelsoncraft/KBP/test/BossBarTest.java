package net.Kelsoncraft.KBP.test;

import net.Kelsoncraft.KBP.KbpMain;
import net.Kelsoncraft.KBP.util.ChatColorUtil;
import net.Kelsoncraft.KBP.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BossBarTest {

    // https://www.youtube.com/watch?v=9apL86E05Bc
    private int taskID = -1;
    private final KbpMain plugin;
    private BossBar bar;

    public BossBarTest(KbpMain passedPlugin){
        this.plugin = passedPlugin;
    }

    public void addPlayer(Player player){
        bar.addPlayer(player);
    }

    public BossBar getBar(){
        return bar;
    }

    public void createBar(){
        bar = Bukkit.createBossBar(ChatColorUtil.format("&b&lKelsonCraft Test"), BarColor.BLUE, BarStyle.SOLID);
        bar.setVisible(true);
        cast();
    }

    public void cast(){
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            int count = -1;
            double progress = 1.0;
            double time = 1.0 / 30;

            @Override
            public void run() {
                bar.setProgress(progress);

                switch(count){
                    case -1:
                        break;
                    case 0:
                        bar.setColor(BarColor.PINK);
                        bar.setTitle(ChatColorUtil.format("&d&lKelsonCraft Test #1"));
                        break;
                    case 1:
                        bar.setColor(BarColor.PURPLE);
                        bar.setTitle(ChatColorUtil.format("&d&lKelsonCraft Test #2"));
                        break;
                    case 2:
                        bar.setColor(BarColor.GREEN);
                        bar.setTitle(ChatColorUtil.format("&d&lKelsonCraft Test #3"));
                        break;
                    case 3:
                    default:
                        bar.setColor(BarColor.BLUE);
                        bar.setTitle(ChatColorUtil.format("&b&lKelsonCraft Test"));
                        count = -1;
                        break;
                }
                progress = progress - time;
                if(progress <= 0){
                    count++;
                    progress = 1.0;
                }
            }
        }, 0, 20);
    }
}
