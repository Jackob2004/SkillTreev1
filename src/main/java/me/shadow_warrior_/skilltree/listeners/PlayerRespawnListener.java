package me.shadow_warrior_.skilltree.listeners;

import me.shadow_warrior_.skilltree.menagers.Test;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerRespawnListener extends Test implements Listener {


    private Test test;

     public PlayerRespawnListener(Test test){
         this.test = test;
     }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
         Player p = e.getPlayer();

         switch (e.getBlock().getType()){
             case EMERALD_ORE:
                 test.addScore(p,4);
             case DIAMOND_ORE:
                 test.addScore(p,3);
             case GOLD_ORE:
                 test.addScore(p,2);
             default:
                 test.addScore(p,1);
         }
    }

    @EventHandler
    public void onPlayerKill(EntityDeathEvent e){
         Player p = e.getEntity().getKiller();

         switch (e.getEntity().getType()){
             case ENDER_DRAGON:
                 test.addScore(p,100);
             case WITHER:
                 test.addScore(p,80);
             case GHAST:
                 test.addScore(p,20);
             case WITCH:
                 test.addScore(p,5);
             case WITHER_SKELETON:
                 test.addScore(p,4);
             case ZOMBIE:
                 test.addScore(p,2);
             case SKELETON:
                 test.addScore(p,2);
             case VEX:
                 test.addScore(p,2);
             case HUSK:
                 test.addScore(p,2);
             case VINDICATOR:
                 test.addScore(p,3);
             case ENDERMAN:
                 test.addScore(p,3);
             default:
                 test.addScore(p,1);
         }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
         Player p = e.getEntity().getPlayer();
         test.removeScore(p, 5);
    }

    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent e){
         int lvl = (test.getScore(e.getPlayer())/200);
         int num = (test.getScore(e.getPlayer())%200);
         e.setFormat(ChatColor.GREEN + "" + ChatColor.BOLD + "[Lvl" + lvl +"] "  +  ChatColor.RESET + e.getPlayer().getDisplayName() + ": " + e.getMessage());
         if(num==0){
             Bukkit.broadcastMessage("§a" + e.getPlayer().getDisplayName() + " has reached level §7" + lvl + "§a!");
         }
    }

}
