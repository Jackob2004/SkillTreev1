package me.shadow_warrior_.skilltree;

import me.shadow_warrior_.skilltree.commands.Addscorecommand;
import me.shadow_warrior_.skilltree.commands.Checkcommand;
import me.shadow_warrior_.skilltree.listeners.PlayerRespawnListener;
import me.shadow_warrior_.skilltree.menagers.Test;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkillTree extends JavaPlugin {


    @Override
    public void onEnable() {
        Test test = new Test();
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(test),this);
        getCommand("block").setExecutor(new Checkcommand(test));
        getCommand("setscore").setExecutor(new Addscorecommand(test));

    }
    // Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user "+p.getPlayer().getUniqueId()+" permission set test.test");

}
